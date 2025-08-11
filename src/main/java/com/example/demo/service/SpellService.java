package com.example.demo.service;

import com.example.demo.domain.Spell;
import com.example.demo.domain.Vocation;
import com.example.demo.dto.spell.CreateSpellDTO;
import com.example.demo.dto.spell.ReadSpellDTO;
import com.example.demo.repository.SpellRepository;
import com.example.demo.repository.VocationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpellService {

    @Autowired
    private SpellRepository spellRepository;

    @Autowired
    private VocationRepository vocationRepository;

    public ReadSpellDTO getSpellById(Long id) {
        Optional<Spell> spellOptional = spellRepository.findById(id);
        if(spellOptional.isEmpty()) {
            throw new EntityNotFoundException("Spell not found");
        }

        Spell spell = spellOptional.get();
        return new ReadSpellDTO(spell);
    }

    public ReadSpellDTO registerSpell(@Valid CreateSpellDTO spellDTO) {
        Spell spell = new Spell(spellDTO);
        for(Long id : spellDTO.vocationsId()) {
            if(vocationRepository.existsById(id)) {
                Vocation vocation = vocationRepository.getReferenceById(id);
                spell.addVocation(vocation);
            }
        }
        Spell savedSpell = spellRepository.save(spell);
        return new ReadSpellDTO(savedSpell);
    }
}
