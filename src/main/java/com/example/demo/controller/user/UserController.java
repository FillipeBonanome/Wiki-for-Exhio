package com.example.demo.controller.user;

import com.example.demo.dto.user.ReadUserDTO;
import com.example.demo.dto.user.UserRoleDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/active")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<ReadUserDTO>> readActiveUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(userService.getActiveUsers(pageable));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<ReadUserDTO>> readAllUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Transactional
    public ResponseEntity<ReadUserDTO> banUser(@PathVariable(name = "id") UUID uuid) {
        return ResponseEntity.ok(userService.banUser(uuid));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Transactional
    public ResponseEntity<ReadUserDTO> changeRole(@PathVariable(name = "id") UUID uuid, @RequestBody UserRoleDTO role) {
        return ResponseEntity.ok(userService.changeRole(uuid, role));
    }
}
