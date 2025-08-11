package com.example.demo.domain;

import com.example.demo.dto.vocation.CreateVocationDTO;
import com.example.demo.dto.vocation.UpdateVocationDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "vocations")
public class Vocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String race;

    @Valid
    @Embedded
    private VocationStats stats;

    //TODO --> Add spell list

    @NotBlank
    private String description;

    public Vocation(@Valid CreateVocationDTO vocationDTO) {
        this.name = vocationDTO.name();
        this.race = vocationDTO.race();
        this.stats = new VocationStats(vocationDTO.stats());
        this.description = vocationDTO.description();
    }

    public void update(@Valid UpdateVocationDTO vocationDTO) {
        if(vocationDTO.name() != null) {
            this.name = vocationDTO.name();
        }
        if(vocationDTO.race() != null) {
            this.race = vocationDTO.race();
        }
        if(vocationDTO.stats() != null) {
            this.stats = new VocationStats(vocationDTO.stats());
        }
        if(vocationDTO.description() != null) {
            this.description = vocationDTO.description();
        }
    }
}
