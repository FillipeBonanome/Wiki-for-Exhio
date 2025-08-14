package com.example.demo.dto.monster;

import com.example.demo.domain.Monster;

public record SimpleMonsterDTO(
        Long id,
        String name
) {
    public SimpleMonsterDTO(Monster monster) {
        this(monster.getId(), monster.getName());
    }
}
