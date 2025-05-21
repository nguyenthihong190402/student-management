package com.example.student_management.converter;

import com.example.student_management.model.CustomUserDetails;
import com.example.student_management.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<UserEntity, CustomUserDetails>{
}
