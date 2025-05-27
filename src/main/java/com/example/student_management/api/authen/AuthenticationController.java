package com.example.student_management.api.authen;

import com.example.student_management.model.request.UserLoginRequest;
import com.example.student_management.model.response.AuthToken;
import com.example.student_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthToken> login(@RequestBody UserLoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
