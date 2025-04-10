package com.example.student_management.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Builder
@Data
public class ErrorResponse {
    private int status;
    private String errorMessage;
    private HttpStatusCode errorCode;
}
