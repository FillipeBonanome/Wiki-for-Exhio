package com.example.demo.controller.quest;

import com.example.demo.dto.quest.CreateQuestDTO;
import com.example.demo.dto.quest.ReadQuestDTO;
import com.example.demo.dto.quest.UpdateQuestDTO;
import com.example.demo.service.QuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public ResponseEntity<Page<ReadQuestDTO>> getQuests(@PageableDefault(size = 10, sort = {"level"}) Pageable pageable) {
        return ResponseEntity.ok(questService.getQuests(pageable));
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadQuestDTO> registerQuest(@RequestBody @Valid CreateQuestDTO questDTO) {
        return ResponseEntity.ok(questService.registerQuest(questDTO));
    }

    @DeleteMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadQuestDTO> deleteQuest(@PathVariable(name = "id") Long id) {
        questService.deleteQuest(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadQuestDTO> updateQuest(@PathVariable(name = "id") Long id, @RequestBody @Valid UpdateQuestDTO questDTO) {
        return ResponseEntity.ok(questService.updateQuest(id, questDTO));
    }

}
