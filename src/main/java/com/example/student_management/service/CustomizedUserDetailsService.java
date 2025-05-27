package com.example.student_management.service;

import com.example.student_management.model.CustomUserDetails;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomizedUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findOneByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return CustomUserDetails.fromUserEntity(user);
    }
}
