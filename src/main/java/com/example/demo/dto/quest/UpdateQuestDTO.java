package com.example.demo.dto.quest;

public record UpdateQuestDTO(
        String name,
        Long huntId,
        ReadRewardDTO reward,
        Long level
) {
}
