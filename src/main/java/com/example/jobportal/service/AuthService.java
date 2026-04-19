package com.example.jobportal.service;

import com.example.jobportal.dto.auth.AuthResponse;
import com.example.jobportal.dto.auth.LoginRequest;
import com.example.jobportal.dto.auth.RegisterRequest;
import com.example.jobportal.dto.auth.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}

