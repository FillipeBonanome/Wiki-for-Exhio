package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.ReadUserDTO;
import com.example.demo.infra.exception.DuplicateResourceException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ReadUserDTO registerUser(CreateUserDTO user) {
        if (userRepository.findByEmail(user.email()).isPresent()) {
            throw new DuplicateResourceException("User", "Email", user.email());
        }
        if(userRepository.findByLogin(user.login()).isPresent()) {
            throw new DuplicateResourceException("User", "Login", user.login());
        }

        User newUser = new User(user);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User savedUser = userRepository.save(newUser);
        return new ReadUserDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getActive()
        );

    }

    public Page<ReadUserDTO> getActiveUsers(Pageable pageable) {
        return userRepository.findAllByActiveTrue(pageable).map(u -> new ReadUserDTO(
                u.getId(),
                u.getName(),
                u.getActive()
        ));
    }

    public Page<ReadUserDTO> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(u -> new ReadUserDTO(
                u.getId(),
                u.getName(),
                u.getActive()
        ));
    }
}
