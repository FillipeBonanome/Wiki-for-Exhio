package com.example.demo.dto.quest;

import com.example.demo.domain.Reward;

public record ReadRewardDTO(
        String item,
        String gold,
        String stats
) {
    public ReadRewardDTO(Reward reward) {
        this(reward.getItem(), reward.getGold(), reward.getStats());
    }
}
