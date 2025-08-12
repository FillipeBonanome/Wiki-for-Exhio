package com.example.demo.infra.security;

import com.example.demo.domain.User;
import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.SecurityErrorDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = getToken(request);
        try {
            if (tokenJWT != null) {
                String subject = tokenService.getSubject(tokenJWT);
                Optional<User> user = userRepository.findByLogin(subject);
                if (user.isEmpty()) {
                    throw new UsernameNotFoundException("User was not found");
                }
                if(!user.get().getActive()) {
                    throw new EntityNotFoundException("User is deleted");
                }
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.get().getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            SecurityErrorDTO errorDTO = new SecurityErrorDTO(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()
            );

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getWriter(), errorDTO);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if(header != null) {
            return header.replace("Bearer ", "");
        }
        return null;
    }
}

