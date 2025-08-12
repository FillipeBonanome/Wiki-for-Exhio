package com.example.demo.service;

import com.example.demo.domain.Hunt;
import com.example.demo.domain.Quest;
import com.example.demo.domain.Reward;
import com.example.demo.dto.quest.CreateQuestDTO;
import com.example.demo.dto.quest.ReadQuestDTO;
import com.example.demo.dto.quest.UpdateQuestDTO;
import com.example.demo.repository.HuntRepository;
import com.example.demo.repository.QuestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private HuntRepository huntRepository;

    public ReadQuestDTO getQuestById(Long id) {
        Quest quest = questRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quest not found"));
        return new ReadQuestDTO(quest);
    }

    public ReadQuestDTO registerQuest(@Valid CreateQuestDTO questDTO) {
        Hunt hunt = huntRepository.findById(questDTO.huntId()).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
        Quest quest = new Quest(questDTO, hunt);
        Quest savedQuest = questRepository.save(quest);
        return new ReadQuestDTO(savedQuest);
    }

    public void deleteQuest(Long id) {
        questRepository.deleteById(id);
    }

    public Page<ReadQuestDTO> getQuests(Pageable pageable) {
        return questRepository.findAll(pageable).map(ReadQuestDTO::new);
    }

    public ReadQuestDTO updateQuest(Long id, UpdateQuestDTO questDTO) {
        Quest quest = questRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quest not found"));
        quest.update(questDTO);

        if(questDTO.huntId() != null) {
            Hunt hunt = huntRepository.findById(questDTO.huntId()).orElseThrow(() -> new EntityNotFoundException("Hunt not found"));
            quest.setHunt(hunt);
        }

        if(questDTO.reward() != null) {
            Reward reward = new Reward(questDTO.reward());
            quest.setReward(reward);
        }

        Quest savedQuest = questRepository.save(quest);
        return new ReadQuestDTO(savedQuest);
    }
}
