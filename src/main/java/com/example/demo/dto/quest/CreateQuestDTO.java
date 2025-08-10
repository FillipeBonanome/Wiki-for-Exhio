package com.example.demo.dto.quest;

public record CreateQuestDTO(
        String name,
        Long huntId,
        ReadRewardDTO reward,
        Long level
) {
}
