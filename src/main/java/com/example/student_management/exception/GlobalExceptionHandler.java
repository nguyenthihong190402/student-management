package com.example.student_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse response = ErrorResponse.builder()
                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getStatusCode())
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .errorMessage(ErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage())
                .build();
        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatusCode()).body(response);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ErrorResponse> handleAppException(AppException appException) {
        ErrorCode errorCode = appException.getErrorCode();
        ErrorResponse response = ErrorResponse.builder()
                .errorMessage(errorCode.getErrorMessage())
                .status(errorCode.getStatus())
                .errorCode(errorCode.getStatusCode())
                .build();
        return ResponseEntity.status(errorCode.getStatusCode()).body(response);
    }
}
