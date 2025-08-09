package com.example.demo.repository;

import com.example.demo.domain.Monster;
import com.example.demo.domain.MonsterCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
    List<Monster> findAllByCategory(MonsterCategory category);
}
