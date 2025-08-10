package com.example.demo.domain;

import com.example.demo.dto.quest.CreateQuestDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "quests")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hunt_id", nullable = false)
    private Hunt hunt;

    @Embedded
    private Reward reward;

    @NotNull
    private Long level;

    public Quest(@Valid CreateQuestDTO questDTO, Hunt hunt) {
        this.name = questDTO.name();
        this.hunt = hunt;
        this.reward = new Reward(questDTO.reward());
        this.level = questDTO.level();;
    }
}
