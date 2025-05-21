package com.example.student_management.service.impl;

import com.example.student_management.model.entity.DeviceTokenEntity;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.model.request.DeviceTokenRequest;
import com.example.student_management.repository.DeviceTokenRepository;
import com.example.student_management.repository.UserRepository;
import com.example.student_management.service.DeviceTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeviceTokenServiceImpl implements DeviceTokenService {
    private final DeviceTokenRepository deviceTokenRepository;
    private final UserRepository userRepository;

    @Override
    public boolean saveDeviceToken(DeviceTokenRequest tokenRequest) {
        DeviceTokenEntity exists = deviceTokenRepository.findByTokenAndUser_Id(tokenRequest.getToken(), tokenRequest.getUserId());
        UserEntity user = userRepository.findOneById(tokenRequest.getUserId());
        if (user != null) {
            if (exists == null) {
                DeviceTokenEntity deviceToken = new DeviceTokenEntity();
                deviceToken.setUser(user);
                deviceToken.setToken(tokenRequest.getToken());
                deviceToken.setExpiryDate(LocalDateTime.now().plusDays(7));
                deviceTokenRepository.save(deviceToken);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserDeviceToken(DeviceTokenRequest requestDTO) {
        DeviceTokenEntity deviceTokenEntity = deviceTokenRepository.findByTokenAndUser_Id(requestDTO.getToken(),
                requestDTO.getUserId());

        if (deviceTokenEntity != null) {
            deviceTokenRepository.delete(deviceTokenEntity);
            return true;
        }

        return false;
    }
}
