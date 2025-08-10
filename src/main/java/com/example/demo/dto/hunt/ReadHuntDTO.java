package com.example.demo.dto.hunt;

import com.example.demo.domain.Hunt;
import com.example.demo.dto.monster.ReadMonsterDTO;
import com.example.demo.dto.quest.ReadQuestDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record ReadHuntDTO(
        Long id,
        String name,
        String description,
        Set<ReadMonsterDTO> monsters,
        String videoURL,
        Long recommendedLevel,
        List<ReadQuestHuntDTO> quests
) {
    public ReadHuntDTO(Hunt hunt) {
        this(
                hunt.getId(),
                hunt.getName(),
                hunt.getDescription(),
                hunt.getMonsters().stream().map(ReadMonsterDTO::new).collect(Collectors.toSet()),
                hunt.getVideoURL(),
                hunt.getRecommendedLevel(),
                hunt.getQuests().stream().map(ReadQuestHuntDTO::new).toList()
        );
    }
}
