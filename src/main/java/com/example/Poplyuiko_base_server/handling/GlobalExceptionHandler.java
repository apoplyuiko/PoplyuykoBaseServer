package com.example.Poplyuiko_base_server.handling;

import com.example.Poplyuiko_base_server.DTOs.BaseSuccessResponse;
import com.example.Poplyuiko_base_server.DTOs.CustomSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomSuccessResponse<?>> handleException(Exception ex) {
        var e = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomSuccessResponse<>(e));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseSuccessResponse>
        handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var e = ex.getBindingResult().getAllErrors();
        List<Integer> err = e.stream().map(item -> Integer.valueOf(Objects.requireNonNull(item.getCode()))).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseSuccessResponse(err.get(0), true));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomSuccessResponse<?>> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new CustomSuccessResponse<>(ex.getErrorCodes().getCode()));
    }
}

