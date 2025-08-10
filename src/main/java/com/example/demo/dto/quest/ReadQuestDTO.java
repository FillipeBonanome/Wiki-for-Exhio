package com.example.demo.dto.quest;

import com.example.demo.domain.Quest;
import com.example.demo.dto.hunt.QuestHuntDTO;

public record ReadQuestDTO(
        String name,
        QuestHuntDTO hunt,
        ReadRewardDTO reward,
        Long level
) {
    public ReadQuestDTO(Quest quest) {
        this(quest.getName(), new QuestHuntDTO(quest.getHunt()), new ReadRewardDTO(quest.getReward()), quest.getLevel());
    }
}
