package com.example.student_management.api.authen;

import com.example.student_management.model.request.DeviceTokenRequest;
import com.example.student_management.service.DeviceTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device-token")
@RequiredArgsConstructor
public class DeviceTokenController {
    private final DeviceTokenService deviceTokenService;

    @PostMapping
    public ResponseEntity<Boolean> saveDeviceToken(@RequestBody DeviceTokenRequest tokenRequest) {
        return ResponseEntity.ok(deviceTokenService.saveDeviceToken(tokenRequest));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteDeviceToken(@RequestBody DeviceTokenRequest tokenRequest) {
        return ResponseEntity.ok(deviceTokenService.deleteUserDeviceToken(tokenRequest));
    }
}
