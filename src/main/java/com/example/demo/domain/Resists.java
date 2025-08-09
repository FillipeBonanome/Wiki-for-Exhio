package com.example.demo.domain;

import com.example.demo.dto.monster.ResistsDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resists {

    private Long physicalResist;
    private Long fireResist;
    private Long iceResist;
    private Long energyResist;
    private Long poisonResist;
    private Long holyResist;
    private Long deathResist;

    public Resists(ResistsDTO resists) {
        this.physicalResist = resists.physicalResist();
        this.fireResist = resists.fireResist();
        this.iceResist = resists.iceResist();
        this.energyResist = resists.energyResist();
        this.poisonResist = resists.poisonResist();
        this.holyResist = resists.holyResist();
        this.deathResist = resists.deathResist();
    }
}
