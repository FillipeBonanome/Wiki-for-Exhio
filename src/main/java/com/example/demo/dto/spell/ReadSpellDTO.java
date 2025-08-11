package com.example.demo.dto.spell;

import com.example.demo.domain.Spell;
import com.example.demo.dto.vocation.HuntVocationDTO;

import java.util.Set;
import java.util.stream.Collectors;

public record ReadSpellDTO(
        Long id,
        String name,
        String description,
        Long level,
        Long manaCost,
        Long soulCost,
        String element,
        Double cooldown,
        String cooldownGroup,
        Long spellRange,
        String videoURL,
        Set<HuntVocationDTO> vocations
) {
    public ReadSpellDTO(Spell spell) {
        this(
                spell.getId(),
                spell.getName(),
                spell.getDescription(),
                spell.getLevel(),
                spell.getManaCost(),
                spell.getSoulCost(),
                spell.getElement(),
                spell.getCooldown(),
                spell.getCooldownGroup(),
                spell.getSpellRange(),
                spell.getVideoURL(),
                spell.getVocations().stream().map(HuntVocationDTO::new).collect(Collectors.toSet())
        );
    }
}
