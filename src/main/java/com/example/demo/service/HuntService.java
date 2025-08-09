package com.example.demo.service;

import com.example.demo.domain.Hunt;
import com.example.demo.dto.hunt.ReadHuntDTO;
import com.example.demo.repository.HuntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuntService {

    @Autowired
    private HuntRepository huntRepository;

    public List<ReadHuntDTO> findAll() {
        List<Hunt> hunts = huntRepository.findAll();
        return hunts.stream().map(h -> new ReadHuntDTO(h)).toList();
    }
}
