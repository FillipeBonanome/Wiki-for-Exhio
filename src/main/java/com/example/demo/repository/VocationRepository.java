package com.example.demo.repository;

import com.example.demo.domain.Vocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocationRepository extends JpaRepository<Vocation, Long> {
}
