package com.example.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	List<Room> findByRoomNameAndCapacity(String roomName, Integer capacity);
	List<Room> findDistinctRoomByEquipments_EquipmentName(String equipmentName);
	List<Room> findByCapacityBetween(Integer capacityFrom, Integer capacityTo);
}
