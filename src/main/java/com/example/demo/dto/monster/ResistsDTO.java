package com.example.demo.dto.monster;

import com.example.demo.domain.Resists;

public record ResistsDTO(
        Long physicalResist,
        Long fireResist,
        Long iceResist,
        Long energyResist,
        Long poisonResist,
        Long holyResist,
        Long deathResist
) {
    public ResistsDTO(Resists resists) {
        this(
                resists.getPhysicalResist(),
                resists.getFireResist(),
                resists.getIceResist(),
                resists.getEnergyResist(),
                resists.getPoisonResist(),
                resists.getHolyResist(),
                resists.getDeathResist()
        );
    }
}
