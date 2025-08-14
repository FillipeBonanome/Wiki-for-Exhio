package com.example.demo.domain;

import com.example.demo.dto.dungeon.CreateDungeonDTO;
import com.example.demo.dto.dungeon.UpdateDungeonDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dungeons")
public class Dungeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "dungeon_monster",
            joinColumns = @JoinColumn(name = "dungeon_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private Set<Monster> monsters = new HashSet<>();

    @NotBlank
    private String dungeonSize;

    @NotNull
    private Long monstersToKill;

    public Dungeon(@Valid CreateDungeonDTO dungeonDTO) {
        this.name = dungeonDTO.name();
        this.dungeonSize = dungeonDTO.dungeonSize();
        this.monstersToKill = dungeonDTO.monstersToKill();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void update(UpdateDungeonDTO dungeonDTO) {
        if(dungeonDTO.name() != null) {
            this.name = dungeonDTO.name();
        }
        if(dungeonDTO.dungeonSize() != null) {
            this.dungeonSize = dungeonDTO.dungeonSize();
        }
        if(dungeonDTO.monstersToKill() != null) {
            this.monstersToKill = dungeonDTO.monstersToKill();
        }
    }
}
