package com.example.demo.dto.vocation;

import com.example.demo.domain.Hunt;
import com.example.demo.domain.Vocation;
import com.example.demo.dto.spell.VocationSpellDTO;

import java.util.Set;
import java.util.stream.Collectors;

public record ReadVocationDTO(
        Long id,
        String name,
        String race,
        VocationStatsDTO stats,
        String description,
        Set<VocationHuntDTO> recommendedHunts,
        Set<VocationSpellDTO> spells
) {
    public ReadVocationDTO(Vocation vocation) {
        this(
                vocation.getId(),
                vocation.getName(),
                vocation.getRace(),
                new VocationStatsDTO(vocation.getStats()),
                vocation.getDescription(),
                vocation.getRecommendedHunts().stream().map(VocationHuntDTO::new).collect(Collectors.toSet()),
                vocation.getSpellList().stream().map(VocationSpellDTO::new).collect(Collectors.toSet())
        );
    }
}
