package com.example.demo.dto.vocation;

import com.example.demo.domain.Vocation;

public record ReadVocationDTO(
        Long id,
        String name,
        String race,
        VocationStatsDTO stats,
        String description
) {
    public ReadVocationDTO(Vocation vocation) {
        this(vocation.getId(), vocation.getName(), vocation.getRace(), new VocationStatsDTO(vocation.getStats()), vocation.getDescription());
    }
}
