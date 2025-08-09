package com.example.demo.service;

import com.example.demo.domain.Hunt;
import com.example.demo.domain.Monster;
import com.example.demo.dto.hunt.CreateHuntDTO;
import com.example.demo.dto.hunt.ReadHuntDTO;
import com.example.demo.repository.HuntRepository;
import com.example.demo.repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuntService {

    @Autowired
    private HuntRepository huntRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    public List<ReadHuntDTO> findAll() {
        List<Hunt> hunts = huntRepository.findAll();
        return hunts.stream().map(ReadHuntDTO::new).toList();
    }

    public ReadHuntDTO registerHunt(@Valid CreateHuntDTO createHuntDTO) {
        Hunt hunt = new Hunt(createHuntDTO);
        Hunt savedHunt = huntRepository.save(hunt);
        return new ReadHuntDTO(savedHunt);
    }

    public ReadHuntDTO addMonsterToHunt(Long huntId, Long monsterId) {
        if (!monsterRepository.existsById(monsterId)) {
            throw new EntityNotFoundException("Monster not found");
        }
        if(!huntRepository.existsById(huntId)) {
            throw new EntityNotFoundException("Hunt not found");
        }

        Hunt hunt = huntRepository.getReferenceById(huntId);
        Monster monster = monsterRepository.getReferenceById(monsterId);

        hunt.addMonster(monster);
        huntRepository.save(hunt);
        return new ReadHuntDTO(hunt);
    }
}
