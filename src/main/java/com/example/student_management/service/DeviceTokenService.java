package com.example.student_management.service;

import com.example.student_management.model.request.DeviceTokenRequest;

public interface DeviceTokenService {
    boolean saveDeviceToken(DeviceTokenRequest tokenRequest);
    boolean deleteUserDeviceToken(DeviceTokenRequest tokenRequest);
}
