package com.example.demo.repository;

import com.example.demo.domain.Dungeon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DungeonRepository extends JpaRepository<Dungeon, Long> {
}
