package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "spells")
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Long level;
    @NotNull
    private Long manaCost;
    @NotNull
    private Long soulCost;
    @NotNull
    private String element;
    @NotNull
    private Double cooldown;
    @NotBlank
    private String cooldownGroup;
    @NotNull
    private Long spellRange;
    private String videoURL;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "spell_vocation",
            joinColumns = @JoinColumn(name = "spell_id"),
            inverseJoinColumns = @JoinColumn(name = "vocation_id")
    )
    private Set<Vocation> vocations = new HashSet<>();

}
