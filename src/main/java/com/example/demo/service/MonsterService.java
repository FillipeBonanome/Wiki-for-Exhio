package com.example.demo.service;

import com.example.demo.domain.Monster;
import com.example.demo.dto.monster.CreateMonsterDTO;
import com.example.demo.dto.monster.ReadMonsterDTO;
import com.example.demo.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public ReadMonsterDTO registerMonster(CreateMonsterDTO monsterDTO) {
        Monster monster = new Monster(monsterDTO);
        Monster savedMonster = monsterRepository.save(monster);
        return new ReadMonsterDTO(savedMonster);
    }

}
