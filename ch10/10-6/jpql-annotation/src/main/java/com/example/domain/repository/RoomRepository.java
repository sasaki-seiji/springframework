package com.example.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query("SELECT r FROM Room r WHERE r.roomName = :roomName")
	List<Room> findByRoomName(@Param("roomName") String roomName);
	
	// 2018.12.23 add
	// see: https://stackoverflow.com/questions/44022076/jparepository-not-supported-for-dml-operations-delete-query
	@Modifying
	@Query("UPDATE Room r SET r.capacity = :capacity")
	Integer updateCapacityAll(@Param("capacity") Integer capacity);
}
