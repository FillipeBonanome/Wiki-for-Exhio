package com.example.demo.controller.vocation;

import com.example.demo.dto.vocation.CreateVocationDTO;
import com.example.demo.dto.vocation.ListVocationsDTO;
import com.example.demo.dto.vocation.ReadVocationDTO;
import com.example.demo.dto.vocation.UpdateVocationDTO;
import com.example.demo.service.VocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocations")
public class VocationController {

    @Autowired
    private VocationService vocationService;

    @GetMapping
    public ResponseEntity<List<ListVocationsDTO>> getVocations() {
        return ResponseEntity.ok(vocationService.getVocations());
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadVocationDTO> registerVocation(@RequestBody @Valid CreateVocationDTO vocationDTO) {
        return ResponseEntity.ok(vocationService.registerVocation(vocationDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadVocationDTO> getVocationById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(vocationService.getVocationById(id));
    }

    @DeleteMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadVocationDTO> deleteVocationById(@PathVariable(name = "id") Long id) {
        vocationService.deleteVocationById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReadVocationDTO> updateVocation(@PathVariable(name = "id") Long id, @RequestBody @Valid UpdateVocationDTO vocationDTO) {
        return ResponseEntity.ok(vocationService.updateVocation(id, vocationDTO));
    }

}
