package com.example.demo.controller.quest;

import com.example.demo.dto.quest.CreateQuestDTO;
import com.example.demo.dto.quest.ReadQuestDTO;
import com.example.demo.service.QuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    private QuestService questService;

    @GetMapping("/{id}")
    public ResponseEntity<ReadQuestDTO> getQuestById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(questService.getQuestById(id));
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadQuestDTO> registerQuest(@RequestBody @Valid CreateQuestDTO questDTO) {
        return ResponseEntity.ok(questService.registerQuest(questDTO));
    }

}
