package com.example.demo.controller.user;

import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.dto.user.ReadUserDTO;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<ReadUserDTO> register(@RequestBody @Valid CreateUserDTO user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

}
