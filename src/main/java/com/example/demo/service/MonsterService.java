package com.example.demo.service;

import com.example.demo.domain.Monster;
import com.example.demo.domain.MonsterCategory;
import com.example.demo.dto.monster.CreateMonsterDTO;
import com.example.demo.dto.monster.ReadMonsterDTO;
import com.example.demo.dto.monster.UpdateMonsterDTO;
import com.example.demo.repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public ReadMonsterDTO registerMonster(CreateMonsterDTO monsterDTO) {
        Monster monster = new Monster(monsterDTO);
        Monster savedMonster = monsterRepository.save(monster);
        return new ReadMonsterDTO(savedMonster);
    }

    public void deleteMonster(Long id) {
        monsterRepository.deleteById(id);
    }

    public ReadMonsterDTO getMonsterById(Long id) {
        Optional<Monster> monsterOptional = monsterRepository.findById(id);
        if (monsterOptional.isEmpty()) {
            throw new EntityNotFoundException("Monster not found");
        }
        return new ReadMonsterDTO(monsterOptional.get());
    }

    public List<ReadMonsterDTO> getMonstersByCategory(MonsterCategory category) {
        List<Monster> monsters = monsterRepository.findAllByCategory(category);
        return monsters.stream().map(ReadMonsterDTO::new).toList();
    }

    public ReadMonsterDTO updateMonster(Long id, UpdateMonsterDTO monsterDTO) {
        Optional<Monster> monsterOptional = monsterRepository.findById(id);
        if (monsterOptional.isEmpty()) {
            throw new EntityNotFoundException("Monster not found");
        }
        Monster monster = monsterOptional.get();
        monster.updateMonster(monsterDTO);
        Monster savedMonster = monsterRepository.save(monster);
        return new ReadMonsterDTO(savedMonster);
    }
}
