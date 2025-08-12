package com.example.demo.service;

import com.example.demo.domain.Hunt;
import com.example.demo.domain.Monster;
import com.example.demo.domain.Vocation;
import com.example.demo.dto.hunt.CreateHuntDTO;
import com.example.demo.dto.hunt.ReadHuntDTO;
import com.example.demo.dto.hunt.UpdateHuntDTO;
import com.example.demo.repository.HuntRepository;
import com.example.demo.repository.MonsterRepository;
import com.example.demo.repository.VocationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HuntService {

    @Autowired
    private HuntRepository huntRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private VocationRepository vocationRepository;

    public List<ReadHuntDTO> findAll() {
        List<Hunt> hunts = huntRepository.findAll();
        return hunts.stream().map(ReadHuntDTO::new).toList();
    }

    public ReadHuntDTO registerHunt(@Valid CreateHuntDTO createHuntDTO) {
        Hunt hunt = new Hunt(createHuntDTO);

        //Adding each recommended vocation
        Set<Long> vocationsId = createHuntDTO.recommendedVocations();
        for(Long id : vocationsId){
            if (vocationRepository.existsById(id)) {
                Vocation vocation = vocationRepository.getReferenceById(id);
                hunt.addVocation(vocation);
            }
        }

        Hunt savedHunt = huntRepository.save(hunt);
        return new ReadHuntDTO(savedHunt);
    }

    public ReadHuntDTO addMonsterToHunt(Long huntId, Long monsterId) {
        Hunt hunt = huntRepository.findById(huntId).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        Monster monster = monsterRepository.findById(monsterId).orElseThrow(() -> new EntityNotFoundException("Monster not found"));
        hunt.addMonster(monster);
        huntRepository.save(hunt);
        return new ReadHuntDTO(hunt);
    }

    public ReadHuntDTO removeMonsterFromHunt(Long huntId, Long monsterId) {
        Hunt hunt = huntRepository.findById(huntId).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        Monster monster = monsterRepository.findById(monsterId).orElseThrow(() -> new EntityNotFoundException("Monster not found"));
        hunt.removeMonster(monster);
        Hunt savedHunt = huntRepository.save(hunt);
        return new ReadHuntDTO(savedHunt);
    }

    public ReadHuntDTO removeVocationFromHunt(Long huntId, Long vocationId) {
        Vocation vocation = vocationRepository.findById(vocationId).orElseThrow(() -> new EntityNotFoundException("Vocation not found"));
        Hunt hunt = huntRepository.findById(huntId).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        hunt.removeVocation(vocation);
        Hunt savedHunt = huntRepository.save(hunt);
        return new ReadHuntDTO(savedHunt);
    }

    public ReadHuntDTO addVocationToHunt(Long huntId, Long vocationId) {
        Vocation vocation = vocationRepository.findById(vocationId).orElseThrow(() -> new EntityNotFoundException("Vocation not found"));
        Hunt hunt = huntRepository.findById(huntId).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        hunt.addVocation(vocation);
        Hunt savedHunt = huntRepository.save(hunt);
        return new ReadHuntDTO(savedHunt);
    }

    public void deleteHunt(Long huntId) {
        huntRepository.deleteById(huntId);
    }

    public ReadHuntDTO getHuntById(Long id) {
        Hunt hunt = huntRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        return new ReadHuntDTO(hunt);
    }

    public ReadHuntDTO updateHunt(Long huntId, UpdateHuntDTO huntDTO) {
        Hunt hunt = huntRepository.findById(huntId).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        hunt.updateHunt(huntDTO);
        Hunt savedHunt = huntRepository.save(hunt);
        return new ReadHuntDTO(savedHunt);
    }


}
