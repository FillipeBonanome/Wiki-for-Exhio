package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Long experience;

    @NotNull
    private Long health;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonsterCategory category;

    @Embedded
    private Resists resists;


}
