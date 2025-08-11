package com.example.demo.dto.vocation;

import com.example.demo.domain.Vocation;

public record ListVocationsDTO(
        Long id,
        String name,
        String race,
        VocationStatsDTO stats
) {
    public ListVocationsDTO(Vocation vocation) {
        this(
                vocation.getId(),
                vocation.getName(),
                vocation.getRace(),
                new VocationStatsDTO(vocation.getStats())
        );
    }
}
