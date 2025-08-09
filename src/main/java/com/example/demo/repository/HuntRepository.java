package com.example.demo.repository;

import com.example.demo.domain.Hunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuntRepository extends JpaRepository<Hunt, Long> {
}
