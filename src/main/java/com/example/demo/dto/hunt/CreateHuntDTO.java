package com.example.demo.dto.hunt;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateHuntDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        String videoURL,
        @NotNull
        Long recommendedLevel
) {
}
