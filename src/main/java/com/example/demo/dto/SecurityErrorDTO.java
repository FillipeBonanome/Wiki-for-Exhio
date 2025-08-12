package com.example.demo.dto;

import java.time.Instant;

public record SecurityErrorDTO(
        int status,
        String message
) {
}
