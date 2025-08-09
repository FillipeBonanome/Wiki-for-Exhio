package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.FullUserDTO;
import com.example.demo.dto.ReadUserDTO;
import com.example.demo.dto.UpdateUserDTO;
import com.example.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //TODO --> Verify safety for password
    @GetMapping
    public ResponseEntity<FullUserDTO> readProfile(Authentication authentication) {
        Optional<User> userOptional = (Optional<User>) authentication.getPrincipal();
        if(userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }

        User user = userOptional.get();

        if(!user.getActive()) {
            throw new EntityNotFoundException("User not found");
        }

        return ResponseEntity.ok(new FullUserDTO(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                true
        ));
    }

    @PatchMapping("/edit")
    @Transactional
    public ResponseEntity<ReadUserDTO> editProfile(Authentication authentication, @RequestBody @Valid UpdateUserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(authentication, userDTO));
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity<ReadUserDTO> deleteProfile(Authentication authentication) {
        return ResponseEntity.ok(userService.deleteUser(authentication));
    }


}
