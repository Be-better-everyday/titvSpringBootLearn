package com.example.demo.testMapper2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleRepository extends JpaRepository<SimpleSource, Integer> {
}
