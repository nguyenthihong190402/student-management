package com.example.student_management.service;

import com.example.student_management.model.entity.UserEntity;

public interface UserService {
    UserEntity findOneByEmail(String email);
}
