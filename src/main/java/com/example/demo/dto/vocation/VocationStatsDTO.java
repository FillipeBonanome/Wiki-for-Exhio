package com.example.demo.dto.vocation;

import com.example.demo.domain.VocationStats;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record VocationStatsDTO(
        @NotNull Integer healthPerLevel,
        @NotNull Integer manaPerLevel,
        @NotNull Integer capPerLevel,
        @NotNull Integer healthRegen,
        @NotNull Integer manaRegen,
        @NotNull Integer magicLevel,
        @NotNull Integer fistSkill,
        @NotNull Integer clubSkill,
        @NotNull Integer swordSkill,
        @NotNull Integer axeSkill,
        @NotNull Integer distanceSkill,
        @NotNull Integer shieldSkill,
        @NotNull Integer fishingSkill
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
