package com.example.demo.domain;

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

}
