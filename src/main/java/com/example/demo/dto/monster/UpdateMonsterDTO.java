package com.example.demo.dto.monster;

import com.example.demo.domain.MonsterCategory;

public record UpdateMonsterDTO(
        String name,
        String description,
        Long experience,
        Long health,
        MonsterCategory category,
        ResistsDTO resists,
        Long level
) {
}
