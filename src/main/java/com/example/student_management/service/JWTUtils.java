package com.example.student_management.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;

public interface JWTUtils {
    String generateToken(Authentication authentication);
    String generateRefreshToken(Authentication authentication);
    String extractEmail(String token);
    String extractIdFromToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
