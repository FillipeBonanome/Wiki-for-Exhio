package com.example.demo.dto;

import jakarta.validation.constraints.Pattern;

public record UpdateUserDTO(
        String name,
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
        String password
) {
}
