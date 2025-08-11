package com.example.demo.dto.spell;

import com.example.demo.domain.Spell;

public record VocationSpellDTO(
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
        String videoURL
) {
    public VocationSpellDTO(Spell spell) {
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
                spell.getVideoURL()
        );
    }
}
