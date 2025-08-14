package com.example.demo.controller.dungeon;

import com.example.demo.dto.dungeon.CreateDungeonDTO;
import com.example.demo.dto.dungeon.ReadDungeonDTO;
import com.example.demo.dto.dungeon.UpdateDungeonDTO;
import com.example.demo.service.DungeonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dungeons")
public class DungeonController {

    @Autowired
    private DungeonService dungeonService;

    @GetMapping("{id}")
    public ResponseEntity<ReadDungeonDTO> gerDungeonById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(dungeonService.getDungeonById(id));
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadDungeonDTO> registerDungeon(@RequestBody @Valid CreateDungeonDTO dungeonDTO) {
        return ResponseEntity.ok(dungeonService.registerDungeon(dungeonDTO));
    }

    @PutMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadDungeonDTO> updateDungeon(@PathVariable(name = "id") Long id, @RequestBody UpdateDungeonDTO dungeonDTO) {
        return ResponseEntity.ok(dungeonService.updateDungeon(id, dungeonDTO));
    }

    @DeleteMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadDungeonDTO> deleteDDungeon(@PathVariable(name = "id") Long id) {
        dungeonService.deleteDungeon(id);
        return ResponseEntity.ok().build();
    }

}
