package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.RoomWithAudit;

public interface RoomWithAuditRepository extends JpaRepository<RoomWithAudit, Integer> {

}
