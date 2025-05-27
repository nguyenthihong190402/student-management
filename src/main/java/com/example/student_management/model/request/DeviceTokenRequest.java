package com.example.student_management.model.request;

import lombok.Data;

@Data
public class DeviceTokenRequest {
    private Long userId;
    private String token;
}
