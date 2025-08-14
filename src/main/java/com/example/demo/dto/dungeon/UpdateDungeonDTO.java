package com.example.demo.dto.dungeon;

import java.util.Set;

public record UpdateDungeonDTO(
        String name,
        Set<Long> monstersId,
        String dungeonSize,
        Long monstersToKill
) {
}
