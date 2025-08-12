package com.example.demo.dto.user;

import jakarta.validation.constraints.Pattern;

public record UpdateUserDTO(
        String name,
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Your password must have an uppercase, a lowercase, a number and a symbol")
        String password
) {
}
