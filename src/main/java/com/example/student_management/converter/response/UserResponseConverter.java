package com.example.student_management.converter.response;

import com.example.student_management.converter.BaseConverter;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseConverter extends BaseConverter<UserEntity, UserResponse> {
}
