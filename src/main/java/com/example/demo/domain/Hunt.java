package com.example.demo.domain;

import com.example.demo.dto.hunt.CreateHuntDTO;
import com.example.demo.dto.hunt.UpdateHuntDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "hunt_monster",
            joinColumns = @JoinColumn(name = "hunt_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private Set<Monster> monsters = new HashSet<>();
    @Column(name = "video_url")
    private String videoURL;
    private Long recommendedLevel;

    public Hunt(@Valid CreateHuntDTO createHuntDTO) {
        this.name = createHuntDTO.name();
        this.description = createHuntDTO.description();
        this.videoURL = createHuntDTO.videoURL();
        this.recommendedLevel = createHuntDTO.recommendedLevel();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public void updateHunt(UpdateHuntDTO huntDTO) {
        if (huntDTO.name() != null) {
            this.name = huntDTO.name();
        }
        if(huntDTO.description() != null) {
            this.description = huntDTO.description();
        }
        if(huntDTO.videoURL() != null) {
            this.videoURL = huntDTO.videoURL();
        }
        if(huntDTO.recommendedLevel() != null) {
            this.recommendedLevel = huntDTO.recommendedLevel();
        }
    }
}
