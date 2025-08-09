package com.example.demo.dto.monster;

import com.example.demo.domain.MonsterCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMonsterDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        Long experience,
        @NotNull
        Long health,
        @NotBlank
        MonsterCategory category,
        ResistsDTO resists,
        @NotNull
        Long level
) {
}
