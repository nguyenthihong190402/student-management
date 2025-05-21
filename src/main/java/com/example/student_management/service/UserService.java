package com.example.student_management.service;

import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.model.request.UserLoginRequest;
import com.example.student_management.model.response.AuthToken;

public interface UserService {
    UserEntity findOneByEmail(String email);
    AuthToken login(UserLoginRequest userLoginRequest);
}
