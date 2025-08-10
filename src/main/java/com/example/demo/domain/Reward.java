package com.example.demo.domain;

import com.example.demo.dto.quest.ReadRewardDTO;
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
public class Reward {

    private String item;
    private String gold;
    private String stats;

    public Reward(ReadRewardDTO reward) {
        this(reward.item(), reward.gold(), reward.stats());
    }
}
