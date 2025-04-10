package com.example.student_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = Exception.class)
//    ResponseEntity<ErrorResponse> handleException(Exception exception) {
//        ErrorResponse response = ErrorResponse.builder()
//                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getStatusCode())
//                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
//                .errorMessage(ErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage())
//                .build();
//        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatusCode()).body(response);
//    }

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

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    ResponseEntity<ErrorResponse> handleMissingParamException(
            MissingServletRequestParameterException exception) {
        ErrorResponse response = ErrorResponse.builder()
                .errorMessage(ErrorCode.MISSING_PARAMETER_REQUEST.getErrorMessage() + exception.getParameterName())
                .status(ErrorCode.MISSING_PARAMETER_REQUEST.getStatus())
                .errorCode(ErrorCode.MISSING_PARAMETER_REQUEST.getStatusCode())
                .build();
        return ResponseEntity.status(ErrorCode.MISSING_PARAMETER_REQUEST.getStatusCode()).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(HttpStatus.BAD_REQUEST)
                .errorMessage("Page number must be >= 0 and page size must be > 0")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
