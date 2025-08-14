package com.example.demo.domain;

import com.example.demo.dto.monster.CreateMonsterDTO;
import com.example.demo.dto.monster.UpdateMonsterDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    @ManyToMany(mappedBy = "monsters")
    private Set<Dungeon> dungeons = new HashSet<>();

    @NotNull
    private Long level;

    public Monster(@Valid CreateMonsterDTO monsterDTO) {
        this.name = monsterDTO.name();
        this.description = monsterDTO.description();
        this.experience = monsterDTO.experience();
        this.health = monsterDTO.health();
        this.category = monsterDTO.category();
        this.resists = new Resists(
                monsterDTO.resists()
        );
        this.level = monsterDTO.level();
    }

    public void updateMonster(UpdateMonsterDTO monsterDTO) {
        if(monsterDTO.name() != null) {
            this.name = monsterDTO.name();
        }
        if(monsterDTO.description() != null) {
            this.description = monsterDTO.description();
        }
        if(monsterDTO.experience() != null) {
            this.experience = monsterDTO.experience();
        }
        if(monsterDTO.health() != null) {
            this.health = monsterDTO.health();
        }
        if(monsterDTO.category() != null) {
            this.category = monsterDTO.category();
        }
        if(monsterDTO.resists() != null) {
            this.resists = new Resists(monsterDTO.resists());
        }
        if(monsterDTO.level() != null) {
            this.level = monsterDTO.level();
        }
    }
}
