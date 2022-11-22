package com.likelion.stopit.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsumeRepository extends JpaRepository<Consume, Long> {
}
