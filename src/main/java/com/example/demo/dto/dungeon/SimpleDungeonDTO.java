package com.example.demo.dto.dungeon;

import com.example.demo.domain.Dungeon;

public record SimpleDungeonDTO(
        Long id,
        String name
) {
    public SimpleDungeonDTO(Dungeon dungeon) {
        this(dungeon.getId(), dungeon.getName());
    }
}
