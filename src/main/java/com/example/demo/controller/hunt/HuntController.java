package com.example.demo.controller.hunt;

import com.example.demo.dto.hunt.ReadHuntDTO;
import com.example.demo.service.HuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hunts")
public class HuntController {

    @Autowired
    private HuntService huntService;

    @GetMapping
    public ResponseEntity<List<ReadHuntDTO>> getHunts() {
        return ResponseEntity.ok(huntService.findAll());
    }

}
