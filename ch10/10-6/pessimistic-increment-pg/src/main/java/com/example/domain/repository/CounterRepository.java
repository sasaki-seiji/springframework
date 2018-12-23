package com.example.domain.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.example.domain.model.Counter;

public interface CounterRepository extends JpaRepository<Counter, Integer> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Override
	Optional<Counter> findById(Integer roomId);
}
