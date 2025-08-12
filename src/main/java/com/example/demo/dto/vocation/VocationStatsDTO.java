package com.example.demo.dto.vocation;

import com.example.demo.domain.VocationStats;
import jakarta.validation.Valid;

public record VocationStatsDTO(
        Integer healthPerLevel,
        Integer manaPerLevel,
        Integer capPerLevel,
        Integer healthRegen,
        Integer manaRegen,
        Integer magicLevel,
        Integer fistSkill,
        Integer clubSkill,
        Integer swordSkill,
        Integer axeSkill,
        Integer distanceSkill,
        Integer shieldSkill,
        Integer fishingSkill
) {
    public VocationStatsDTO(@Valid VocationStats stats) {
        this(
                stats.getHealthPerLevel(),
                stats.getManaPerLevel(),
                stats.getCapPerLevel(),
                stats.getHealthRegen(),
                stats.getManaRegen(),
                stats.getMagicLevel(),
                stats.getFistSkill(),
                stats.getClubSkill(),
                stats.getSwordSkill(),
                stats.getAxeSkill(),
                stats.getDistanceSkill(),
                stats.getShieldSkill(),
                stats.getFishingSkill()
        );
    }
}
