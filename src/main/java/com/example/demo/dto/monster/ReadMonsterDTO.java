package com.example.demo.dto.monster;

import com.example.demo.domain.Monster;
import com.example.demo.domain.MonsterCategory;

/*
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
 */
public record ReadMonsterDTO(
        Long id,
        String name,
        String description,
        Long experience,
        Long health,
        MonsterCategory category,
        ResistsDTO resists
) {
    public ReadMonsterDTO(Monster savedMonster) {
        this(
                savedMonster.getId(),
                savedMonster.getName(),
                savedMonster.getDescription(),
                savedMonster.getExperience(),
                savedMonster.getHealth(),
                savedMonster.getCategory(),
                new ResistsDTO(savedMonster.getResists())
            );
    }
}
