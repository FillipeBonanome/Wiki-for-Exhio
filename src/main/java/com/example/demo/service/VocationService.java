package com.example.demo.service;

import com.example.demo.domain.Vocation;
import com.example.demo.dto.vocation.CreateVocationDTO;
import com.example.demo.dto.vocation.ReadVocationDTO;
import com.example.demo.dto.vocation.UpdateVocationDTO;
import com.example.demo.repository.VocationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ReadVocationDTO getVocationById(Long id) {
        Optional<Vocation> vocationOptional = vocationRepository.findById(id);
        if(vocationOptional.isEmpty()) {
            throw new EntityNotFoundException("Vocation not found");
        }
        Vocation vocation = vocationOptional.get();
        return new ReadVocationDTO(vocation);
    }

    public void deleteVocationById(Long id) {
        vocationRepository.deleteById(id);
    }

    public ReadVocationDTO updateVocation(Long id, @Valid UpdateVocationDTO vocationDTO) {
        Optional<Vocation> vocationOptional = vocationRepository.findById(id);
        if(vocationOptional.isEmpty()) {
            throw new EntityNotFoundException("Vocation not found");
        }
        Vocation vocation = vocationOptional.get();
        vocation.update(vocationDTO);
        Vocation savedVocation = vocationRepository.save(vocation);
        return new ReadVocationDTO(savedVocation);
    }
}
