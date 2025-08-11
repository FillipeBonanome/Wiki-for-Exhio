package com.example.demo.dto.quest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateQuestDTO(
        @NotBlank
        String name,
        @NotNull
        Long huntId,
        ReadRewardDTO reward,
        @NotNull
        Long level
) {
}
