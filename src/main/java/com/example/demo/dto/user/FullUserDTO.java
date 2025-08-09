package com.example.demo.dto.user;

import com.example.demo.domain.UserRole;

import java.util.UUID;

/*
 @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String login;

    @NotBlank
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
    private String password;

    @NotBlank
    @Email
    private String email;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    private Boolean active;
 */
public record FullUserDTO(
        UUID id,
        String name,
        String login,
        String password,
        String email,
        UserRole role,
        Boolean active
) {
}
