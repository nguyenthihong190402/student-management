package com.example.student_management.service.impl;

import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.repository.UserRepository;
import com.example.student_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }
}
