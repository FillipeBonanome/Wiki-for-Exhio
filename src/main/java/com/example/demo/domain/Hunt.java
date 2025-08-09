package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "hunts")
public class Hunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hunt_monster",
            joinColumns = @JoinColumn(name = "hunt_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private Set<Monster> monsters = new HashSet<>();
    private String videoURL;
    private Long recommendedLevel;

}
