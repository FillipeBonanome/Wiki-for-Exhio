package com.example.demo.service;

import com.example.demo.domain.Hunt;
import com.example.demo.domain.Quest;
import com.example.demo.dto.quest.CreateQuestDTO;
import com.example.demo.dto.quest.ReadQuestDTO;
import com.example.demo.repository.HuntRepository;
import com.example.demo.repository.QuestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private HuntRepository huntRepository;

    public ReadQuestDTO getQuestById(Long id) {
        Optional<Quest> questOptional = questRepository.findById(id);
        if(questOptional.isEmpty()) {
            throw new EntityNotFoundException("Quest not found");
        }
        Quest quest = questOptional.get();
        return new ReadQuestDTO(quest);
    }

    public ReadQuestDTO registerQuest(@Valid CreateQuestDTO questDTO) {
        Optional<Hunt> huntOptional = huntRepository.findById(questDTO.huntId());
        if (huntOptional.isEmpty()) {
            throw new EntityNotFoundException("Hunt not found");
        }

        Hunt hunt = huntOptional.get();
        Quest quest = new Quest(questDTO, hunt);
        Quest savedQuest = questRepository.save(quest);
        return new ReadQuestDTO(savedQuest);
    }
}
