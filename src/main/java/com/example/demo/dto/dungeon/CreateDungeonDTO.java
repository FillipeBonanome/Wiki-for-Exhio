package com.example.demo.dto.dungeon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CreateDungeonDTO(
        @NotBlank
        String name,
        @NotEmpty
        Set<Long> monstersId,
        @NotBlank
        String dungeonSize,
        @NotNull
        Long monstersToKill
) {
}
