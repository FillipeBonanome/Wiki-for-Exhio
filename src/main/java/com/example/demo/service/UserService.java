package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.ReadUserDTO;
import com.example.demo.dto.UpdateUserDTO;
import com.example.demo.infra.exception.DuplicateResourceException;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public ReadUserDTO updateUser(Authentication authentication, UpdateUserDTO userDTO) {
        Optional<User> userOptional = (Optional<User>) authentication.getPrincipal();
        if(userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }

        User user = userOptional.get();

        if (!user.getActive()) {
            throw new EntityNotFoundException("User not found");
        }

        if(userDTO.name() != null) {
            user.setName(userDTO.name());
        }

        if(userDTO.password() != null) {
            user.setPassword(passwordEncoder.encode(userDTO.password()));
        }

        User savedUser = userRepository.save(user);
        return new ReadUserDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getActive()
        );
    }

    public ReadUserDTO deleteUser(Authentication authentication){
        Optional<User> userOptional = (Optional<User>) authentication.getPrincipal();
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        User user = userOptional.get();
        user.setActive(false);
        User savedUser = userRepository.save(user);
        return new ReadUserDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getActive()
        );
    }

    public ReadUserDTO banUser(UUID uuid) {
        Optional<User> userOptional = userRepository.findById(uuid);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        User user = userOptional.get();
        user.setActive(false);
        User savedUser = userRepository.save(user);
        return new ReadUserDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getActive()
        );

    }
}
