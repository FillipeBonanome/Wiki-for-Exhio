package com.example.demo.dto.hunt;

import com.example.demo.domain.Quest;
import com.example.demo.dto.quest.ReadRewardDTO;

public record ReadQuestHuntDTO(
        String name,
        ReadRewardDTO reward,
        Long level
) {
    public ReadQuestHuntDTO(Quest quest) {
        this(quest.getName(), new ReadRewardDTO(quest.getReward()), quest.getLevel());
    }
}
