package com.example.demo.controller.monster;

import com.example.demo.dto.monster.CreateMonsterDTO;
import com.example.demo.dto.monster.ReadMonsterDTO;
import com.example.demo.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
