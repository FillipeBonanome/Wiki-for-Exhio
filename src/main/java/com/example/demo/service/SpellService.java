package com.example.demo.service;

import com.example.demo.domain.Spell;
import com.example.demo.domain.Vocation;
import com.example.demo.dto.spell.CreateSpellDTO;
import com.example.demo.dto.spell.ReadSpellDTO;
import com.example.demo.dto.spell.UpdateSpellDTO;
import com.example.demo.repository.SpellRepository;
import com.example.demo.repository.VocationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class SpellService {

    @Autowired
    private SpellRepository spellRepository;

    @Autowired
    private VocationRepository vocationRepository;

    public ReadSpellDTO getSpellById(Long id) {
        Spell spell = spellRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Spell not found"));
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

    public ReadSpellDTO updateSpell(Long id, UpdateSpellDTO spellDTO) {
        Spell spell = spellRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Spell not found"));
        spell.update(spellDTO);
        if(spellDTO.vocationsId() != null) {
            spell.setVocations(new HashSet<>());
            for (Long vocId : spellDTO.vocationsId()) {
                if (vocationRepository.existsById(vocId)) {
                    Vocation vocation = vocationRepository.getReferenceById(vocId);
                    spell.addVocation(vocation);
                }
            }
        }

        Spell savedSpell = spellRepository.save(spell);
        return new ReadSpellDTO(savedSpell);
    }

    public void deleteSpell(Long id) {
        spellRepository.deleteById(id);
    }
}
