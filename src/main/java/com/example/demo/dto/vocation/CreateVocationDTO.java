package com.example.demo.dto.vocation;

public record CreateVocationDTO(
        String name,
        String race,
        VocationStatsDTO stats,
        String description
) {
}
