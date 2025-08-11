package com.example.demo.dto.spell;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CreateSpellDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        Long level,
        @NotNull
        Long manaCost,
        @NotNull
        Long soulCost,
        @NotBlank
        String element,
        @NotNull
        Double cooldown,
        @NotBlank
        String cooldownGroup,
        @NotNull
        Long spellRange,
        @NotBlank
        String videoURL,
        @NotEmpty
        Set<Long> vocationsId
) {
}
