package com.example.demo.domain;

import com.example.demo.dto.vocation.CreateVocationDTO;
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
}
