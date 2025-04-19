package com.example.student_management.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;

public interface JWTUtils {
    String generateToken(UserDetails userDetails);
    String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails);
    String extractEmail(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
