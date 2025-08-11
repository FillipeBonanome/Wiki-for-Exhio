package com.example.demo.controller.spell;

import com.example.demo.dto.spell.CreateSpellDTO;
import com.example.demo.dto.spell.ReadSpellDTO;
import com.example.demo.dto.spell.UpdateSpellDTO;
import com.example.demo.service.SpellService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spells")
public class SpellController {

    @Autowired
    private SpellService spellService;

    @GetMapping("{id}")
    public ResponseEntity<ReadSpellDTO> getSpellById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(spellService.getSpellById(id));
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadSpellDTO> registerSpell(@RequestBody @Valid CreateSpellDTO spellDTO) {
        return ResponseEntity.ok(spellService.registerSpell(spellDTO));
    }

    @PutMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadSpellDTO> updateSpell(@PathVariable(name = "id") Long id, @RequestBody UpdateSpellDTO spellDTO) {
        return ResponseEntity.ok(spellService.updateSpell(id, spellDTO));
    }

    @DeleteMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadSpellDTO> updateSpell(@PathVariable(name = "id") Long id) {
        spellService.deleteSpell(id);
        return ResponseEntity.ok().build();
    }

}
