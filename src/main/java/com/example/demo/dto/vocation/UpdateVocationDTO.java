package com.example.demo.dto.vocation;

public record UpdateVocationDTO(
        String name,
        String race,
        VocationStatsDTO stats,
        String description
) {
}
