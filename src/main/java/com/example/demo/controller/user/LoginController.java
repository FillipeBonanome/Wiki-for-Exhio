package com.example.demo.controller.user;

import com.example.demo.domain.User;
import com.example.demo.dto.user.LoginUserDTO;
import com.example.demo.dto.TokenDTO;
import com.example.demo.service.TokenService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> loginUser(@RequestBody @Valid LoginUserDTO login) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication authentication = authenticationManager.authenticate(token);

        User user = (User) authentication.getPrincipal();

        if (!user.getActive()) {
            throw new EntityNotFoundException("User not found");
        }

        String tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }

}
