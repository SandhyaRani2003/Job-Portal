package com.example.jobportal.controller;

import com.example.jobportal.api.ApiResponse;
import com.example.jobportal.dto.auth.AuthResponse;
import com.example.jobportal.dto.auth.LoginRequest;
import com.example.jobportal.dto.auth.RegisterRequest;
import com.example.jobportal.dto.auth.UserResponse;
import com.example.jobportal.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody RegisterRequest request) {
        UserResponse user = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("User registered successfully", user));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse token = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success("Login successful", token));
    }
}