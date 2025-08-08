package com.example.demo.dto;

import java.util.UUID;

public record ReadUserDTO(
        UUID id,
        String name,
        Boolean active
) {
}
