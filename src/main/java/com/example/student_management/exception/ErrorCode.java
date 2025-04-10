package com.example.student_management.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500,"Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    DUPLICATE_EMAIL(409,"Email already exists", HttpStatus.BAD_REQUEST),
    DUPLICATE_STUDENT_CODE(409,"Student code already exists", HttpStatus.BAD_REQUEST);
    private final String errorMessage;
    private final HttpStatusCode statusCode;
    private final int status;
    ErrorCode(int status,String errorMessage, HttpStatusCode statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.status = status;
    }
}
