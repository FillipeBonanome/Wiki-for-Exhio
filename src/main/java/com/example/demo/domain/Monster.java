package com.example.demo.domain;

import com.example.demo.dto.monster.CreateMonsterDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Long experience;

    @NotNull
    private Long health;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonsterCategory category;

    @Embedded
    private Resists resists;

    @ManyToMany(mappedBy = "monsters")
    private Set<Hunt> hunts = new HashSet<>();


    public Monster(CreateMonsterDTO monsterDTO) {
        this.name = monsterDTO.name();
        this.description = monsterDTO.description();
        this.experience = monsterDTO.experience();
        this.health = monsterDTO.health();
        this.category = monsterDTO.category();
        this.resists = new Resists(
                monsterDTO.resists()
        );

    }
}
