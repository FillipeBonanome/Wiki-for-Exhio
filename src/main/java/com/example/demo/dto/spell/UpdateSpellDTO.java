package com.example.demo.dto.spell;

import java.util.Set;

public record UpdateSpellDTO(
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
        Set<Long> vocationsId
) {
}
