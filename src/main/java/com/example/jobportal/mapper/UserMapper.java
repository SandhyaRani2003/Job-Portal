package com.example.jobportal.mapper;

import com.example.jobportal.dto.auth.UserResponse;
import com.example.jobportal.model.User;

public final class UserMapper {
    private UserMapper() {
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getRole());
    }
}

