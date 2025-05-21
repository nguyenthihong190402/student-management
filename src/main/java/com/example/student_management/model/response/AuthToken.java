package com.example.student_management.model.response;

import com.example.student_management.model.CustomUserDetails;
import com.example.student_management.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {
    private String accessToken;
    private String refreshToken;
    private CustomUserDetails user;
}
