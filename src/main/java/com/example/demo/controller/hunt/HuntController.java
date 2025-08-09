package com.example.demo.controller.hunt;

import com.example.demo.dto.hunt.CreateHuntDTO;
import com.example.demo.dto.hunt.ReadHuntDTO;
import com.example.demo.service.HuntService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hunts")
public class HuntController {

    @Autowired
    private HuntService huntService;

    @GetMapping
    public ResponseEntity<List<ReadHuntDTO>> getHunts() {
        return ResponseEntity.ok(huntService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadHuntDTO> getHunt(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(huntService.getHuntById(id));
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadHuntDTO> addHunt(@RequestBody @Valid CreateHuntDTO createHuntDTO) {
        return ResponseEntity.ok(huntService.registerHunt(createHuntDTO));
    }

    @PostMapping("{id}/add/{monster_id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadHuntDTO> addMonsterToHunt(@PathVariable(name = "id") Long huntId, @PathVariable(name = "monster_id") Long monsterId) {
        return ResponseEntity.ok(huntService.addMonsterToHunt(huntId, monsterId));
    }

    @PostMapping("{id}/remove/{monster_id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadHuntDTO> removeMonsterFromHunt(@PathVariable(name = "id") Long huntId, @PathVariable(name = "monster_id") Long monsterId) {
        return ResponseEntity.ok(huntService.removeMonsterFromHunt(huntId, monsterId));
    }

    @DeleteMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteHunt(@PathVariable(name = "id") Long huntId) {
        huntService.deleteHunt(huntId);
        return ResponseEntity.ok().build();
    }

}
