package com.example.student_management.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class AppException extends RuntimeException{
    private final ErrorCode errorCode;
}
