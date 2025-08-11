package com.example.demo.dto.vocation;

import com.example.demo.domain.Hunt;

public record VocationHuntDTO(
        Long id,
        String name
) {
    public VocationHuntDTO(Hunt hunt) {
        this(hunt.getId(), hunt.getName());
    }
}
