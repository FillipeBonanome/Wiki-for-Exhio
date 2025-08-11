package com.example.demo.domain;

import com.example.demo.dto.vocation.VocationStatsDTO;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VocationStats {

    @NotNull
    private Integer healthPerLevel;
    @NotNull
    private Integer manaPerLevel;
    @NotNull
    private Integer capPerLevel;
    @NotNull
    private Integer healthRegen;
    @NotNull
    private Integer manaRegen;
    @NotNull
    private Integer magicLevel;
    @NotNull
    private Integer fistSkill;
    @NotNull
    private Integer clubSkill;
    @NotNull
    private Integer swordSkill;
    @NotNull
    private Integer axeSkill;
    @NotNull
    private Integer distanceSkill;
    @NotNull
    private Integer shieldSkill;
    @NotNull
    private Integer fishingSkill;

    public VocationStats(VocationStatsDTO stats) {
        this.healthPerLevel = stats.healthPerLevel();
        this.manaPerLevel = stats.manaPerLevel();
        this.capPerLevel = stats.capPerLevel();
        this.healthRegen = stats.healthRegen();
        this.manaRegen = stats.manaRegen();
        this.magicLevel = stats.magicLevel();
        this.fistSkill = stats.fistSkill();
        this.clubSkill = stats.clubSkill();
        this.swordSkill = stats.swordSkill();
        this.axeSkill = stats.axeSkill();
        this.distanceSkill = stats.distanceSkill();
        this.shieldSkill = stats.shieldSkill();
        this.fishingSkill = stats.fishingSkill();
    }
}
