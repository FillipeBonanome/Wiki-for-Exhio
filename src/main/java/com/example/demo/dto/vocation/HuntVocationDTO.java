package com.example.demo.dto.vocation;

import com.example.demo.domain.Vocation;

public record HuntVocationDTO(
        Long id,
        String name
) {
    public HuntVocationDTO(Vocation vocation) {
        this(vocation.getId(), vocation.getName());
    }
}
