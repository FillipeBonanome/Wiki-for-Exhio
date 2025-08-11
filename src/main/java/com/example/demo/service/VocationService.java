package com.example.demo.service;

import com.example.demo.domain.Vocation;
import com.example.demo.dto.vocation.CreateVocationDTO;
import com.example.demo.dto.vocation.ReadVocationDTO;
import com.example.demo.repository.VocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocationService {

    @Autowired
    private VocationRepository vocationRepository;

    public List<ReadVocationDTO> getVocations() {
        return vocationRepository.findAll().stream().map(ReadVocationDTO::new).toList();
    }

    public ReadVocationDTO registerVocation(@Valid CreateVocationDTO vocationDTO) {
        Vocation vocation = new Vocation(vocationDTO);
        Vocation savedVocation = vocationRepository.save(vocation);
        return new ReadVocationDTO(savedVocation);
    }
}
