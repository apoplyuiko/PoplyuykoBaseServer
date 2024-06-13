package com.example.Poplyuiko_base_server.handling;

import com.example.Poplyuiko_base_server.DTOs.BaseSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseSuccessResponse> handleException(Exception ex) {
        BaseSuccessResponse response = new BaseSuccessResponse();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setSuccess(false);
        response.setMessage("Internal Server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseSuccessResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        BaseSuccessResponse response = new BaseSuccessResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setSuccess(false);
        response.setMessage("Validation error");
        response.setErrors(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({ToDoNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BaseSuccessResponse> handleToDoNotFoundException(ToDoNotFoundException ex) {
        ErrorCodes errorCode = ErrorCodes.TASK_NOT_FOUND;
        BaseSuccessResponse response = new BaseSuccessResponse();
        response.setStatusCode(errorCode.getCode());
        response.setSuccess(false);
        response.setMessage(errorCode.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

