package com.example.demo.controller.monster;

import com.example.demo.domain.MonsterCategory;
import com.example.demo.dto.monster.CreateMonsterDTO;
import com.example.demo.dto.monster.ReadMonsterDTO;
import com.example.demo.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadMonsterDTO> registerMonster(@RequestBody CreateMonsterDTO monsterDTO) {
        return ResponseEntity.ok(monsterService.registerMonster(monsterDTO));
    }

    @DeleteMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadMonsterDTO> deleteMonster(@PathVariable(name = "id") Long id) {
        monsterService.deleteMonster(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadMonsterDTO> getMonsterById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(monsterService.getMonsterById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ReadMonsterDTO>> getMonstersByCategory(@PathVariable(name = "category") MonsterCategory category) {
        return ResponseEntity.ok(monsterService.getMonstersByCategory(category));
    }

}
