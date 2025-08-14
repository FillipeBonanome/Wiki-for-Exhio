package com.example.demo.service;

import com.example.demo.domain.Dungeon;
import com.example.demo.domain.Monster;
import com.example.demo.dto.dungeon.CreateDungeonDTO;
import com.example.demo.dto.dungeon.ReadDungeonDTO;
import com.example.demo.dto.dungeon.UpdateDungeonDTO;
import com.example.demo.repository.DungeonRepository;
import com.example.demo.repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DungeonService {

    @Autowired
    private DungeonRepository dungeonRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    public ReadDungeonDTO getDungeonById(Long id) {
        Dungeon dungeon = dungeonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dungeon not found"));
        return new ReadDungeonDTO(dungeon);
    }

    public ReadDungeonDTO registerDungeon(@Valid CreateDungeonDTO dungeonDTO) {
        Dungeon dungeon = new Dungeon(dungeonDTO);

        Set<Long> monstersId = dungeonDTO.monstersId();
        for(Long id : monstersId) {
            if (monsterRepository.existsById(id)) {
                Monster monster = monsterRepository.getReferenceById(id);
                dungeon.addMonster(monster);
            }
        }

        Dungeon savedDungeon = dungeonRepository.save(dungeon);
        return new ReadDungeonDTO(savedDungeon);
    }

    public ReadDungeonDTO updateDungeon(Long id, UpdateDungeonDTO dungeonDTO) {
        Dungeon dungeon = dungeonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dungeon not found"));
        dungeon.update(dungeonDTO);

        //TODO --> Refactor
        if(dungeonDTO.monstersId() != null) {
            dungeon.setMonsters(new HashSet<>());
            for(Long monsterId : dungeonDTO.monstersId()) {
                if(monsterRepository.existsById(monsterId)) {
                    Monster monster = monsterRepository.getReferenceById(monsterId);
                    dungeon.addMonster(monster);
                }
            }
        }

        Dungeon savedDungeon = dungeonRepository.save(dungeon);
        return new ReadDungeonDTO(savedDungeon);
    }

    public void deleteDungeon(Long id) {
        dungeonRepository.deleteById(id);
    }
}
