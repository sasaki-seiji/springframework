package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

public interface RoomService {
	// 10.2.3: pessimistic lock
	void updateRoomWithPessimisticLock(Integer id, String roomName, Integer capacity);
	
	// 10.2.2: update JPQL
	Integer updateCapacityAll(Integer capacity);
	
	// 10.2.2: JOIN FETCH
	List<Room> getRoomsByNameFetch(String roomName);
	
	// 10.2.1: CRUD operations with JPA
	Room getRoom(Integer roomId);
	Room createRoom(String roomName, Integer capacity);
	Room updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
	List<Room> getAllRooms();
	
	// 10.1.6: JPQL
	List<Room> getRoomsByName(String roomName);
	
	// 10.1.5: relation
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	Room getRoomOfEquipment(Integer equipmentId);
}
