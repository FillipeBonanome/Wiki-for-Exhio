package com.example.demo.dto.user;

import com.example.demo.domain.UserRole;

import java.util.UUID;

public record ReadUserDTO(
        UUID id,
        String name,
        Boolean active,
        UserRole role
) {
}
