package com.example.demo.dto.hunt;

import com.example.demo.domain.Hunt;

public record ReadHuntMonsterDTO(
        Long id,
        String name
) {
    public ReadHuntMonsterDTO(Hunt hunt) {
        this(hunt.getId(), hunt.getName());
    }
}
