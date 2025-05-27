package com.example.student_management.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500,"Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    DUPLICATE_EMAIL(409,"Email already exists", HttpStatus.BAD_REQUEST),
    DUPLICATE_STUDENT_CODE(409,"Student code already exists", HttpStatus.BAD_REQUEST),
    STUDENT_NOT_FOUNT(404,"Student does not exists", HttpStatus.NOT_FOUND),
    USER_NOT_FOUNT(404,"User does not exists", HttpStatus.NOT_FOUND),
    MISSING_PARAMETER_REQUEST(400,"Missing parameter ", HttpStatus.BAD_REQUEST),
    INVALID_PAGE_REQUEST(400,"Invalid page request ", HttpStatus.BAD_REQUEST);
    private final String errorMessage;
    private final HttpStatusCode statusCode;
    private final int status;
    ErrorCode(int status,String errorMessage, HttpStatusCode statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.status = status;
    }
}
