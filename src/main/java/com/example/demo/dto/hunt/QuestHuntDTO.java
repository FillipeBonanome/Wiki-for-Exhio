package com.example.demo.dto.hunt;

import com.example.demo.domain.Hunt;

public record QuestHuntDTO(
        Long id,
        String name
) {
    public QuestHuntDTO(Hunt hunt) {
        this(hunt.getId(), hunt.getName());
    }
}
