package com.example.repository;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room_with_version;

public interface RoomService {
	// 10.2.3: optimistic lock
	void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity);
	
	// 10.2.2: update JPQL
	Integer updateCapacityAll(Integer capacity);
	
	// 10.2.2: JOIN FETCH
	List<Room_with_version> getRoomsByNameFetch(String roomName);
	
	// 10.2.1: CRUD operations with JPA
	Room_with_version getRoom(Integer roomId);
	Room_with_version createRoom(String roomName, Integer capacity);
	Room_with_version updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
	List<Room_with_version> getAllRooms();
	
	// 10.1.6: JPQL
	List<Room_with_version> getRoomsByName(String roomName);
	
	// 10.1.5: relation
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	Room_with_version getRoomOfEquipment(Integer equipmentId);
}
