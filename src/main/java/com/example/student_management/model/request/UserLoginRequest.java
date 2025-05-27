package com.example.student_management.model.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
