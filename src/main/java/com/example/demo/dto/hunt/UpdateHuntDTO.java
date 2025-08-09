package com.example.demo.dto.hunt;

public record UpdateHuntDTO(
        String name,
        String description,
        String videoURL,
        Long recommendedLevel
) {
}
