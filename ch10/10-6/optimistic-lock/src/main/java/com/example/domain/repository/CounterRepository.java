package com.example.domain.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.example.domain.model.RoomWithVersion;

public interface RoomWithVersionRepository extends JpaRepository<RoomWithVersion, Integer> {
	@Lock(LockModeType.OPTIMISTIC)
	@Override
	Optional<RoomWithVersion> findById(Integer roomId);
}
