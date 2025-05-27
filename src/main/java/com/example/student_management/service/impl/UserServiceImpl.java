package com.example.student_management.service.impl;

import com.example.student_management.model.CustomUserDetails;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.model.request.UserLoginRequest;
import com.example.student_management.model.response.AuthToken;
import com.example.student_management.repository.UserRepository;
import com.example.student_management.service.JWTUtils;
import com.example.student_management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    @Override
    public UserEntity findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public AuthToken login(UserLoginRequest userLoginRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequest.getEmail(),
                        userLoginRequest.getPassword()));
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String accessToken = jwtUtils.generateToken(authentication);
        final Long userId = user.getId();
        final String email = user.getEmail();
        return new AuthToken(accessToken,userId,email);
    }

}
