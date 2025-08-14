package com.example.demo.dto.dungeon;

import com.example.demo.domain.Dungeon;
import com.example.demo.dto.hunt.ReadHuntMonsterDTO;
import com.example.demo.dto.monster.SimpleMonsterDTO;

import java.util.Set;
import java.util.stream.Collectors;

public record ReadDungeonDTO(
        Long id,
        String name,
        Set<SimpleMonsterDTO> monsters,
        String dungeonSize,
        Long monstersToKill
) {
    public ReadDungeonDTO(Dungeon dungeon) {
        this(
                dungeon.getId(),
                dungeon.getName(),
                dungeon.getMonsters().stream().map(SimpleMonsterDTO::new).collect(Collectors.toSet()),
                dungeon.getDungeonSize(),
                dungeon.getMonstersToKill()
        );
    }
}
