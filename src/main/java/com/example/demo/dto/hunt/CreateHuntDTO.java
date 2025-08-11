package com.example.demo.dto.hunt;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CreateHuntDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        String videoURL,
        @NotNull
        Long recommendedLevel,
        @NotEmpty
        Set<Long> recommendedVocations
) {
}
