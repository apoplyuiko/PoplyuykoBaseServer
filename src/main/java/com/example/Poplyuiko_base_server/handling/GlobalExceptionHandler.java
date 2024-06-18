package com.example.Poplyuiko_base_server.handling;

import com.example.Poplyuiko_base_server.response.BaseSuccessResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.example.Poplyuiko_base_server.handling.ValidationConstants.HTTP_MESSAGE_NOT_READABLE_EXCEPTION;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseSuccessResponse>
        handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var e = ex.getBindingResult().getAllErrors();
        Integer err = e.stream()
                .map(item -> ErrorCodes.ERROR_CODE_MAP.get(item.getDefaultMessage()))
                .findFirst()
                .orElse(0);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseSuccessResponse(err, true, null));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseSuccessResponse> handleCustomException(CustomException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseSuccessResponse(
                        ErrorCodes.ERROR_CODE_MAP.get(
                                ex.getErrorCodes().getMessage()), true, null));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseSuccessResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        var errorCodes = ex.getConstraintViolations().stream()
                .map(err -> ErrorCodes.ERROR_CODE_MAP.get(err.getMessage())).toList();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseSuccessResponse(errorCodes.get(0), true, errorCodes));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseSuccessResponse> handleHttpMessageNotReadableException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseSuccessResponse(ErrorCodes.ERROR_CODE_MAP
                        .get(HTTP_MESSAGE_NOT_READABLE_EXCEPTION), true, null));
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<BaseSuccessResponse> handleInvalidDataAccessApiUsageException(
            InvalidDataAccessApiUsageException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseSuccessResponse(ErrorCodes.ERROR_CODE_MAP
                        .get(ex.getMessage()), true, null));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<BaseSuccessResponse> handleMethodArgumentTypeMismatchException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseSuccessResponse(ErrorCodes.ERROR_CODE_MAP
                        .get(HTTP_MESSAGE_NOT_READABLE_EXCEPTION), true, null));
    }
}
