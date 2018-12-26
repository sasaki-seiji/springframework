package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

public interface RoomService {
	// 10.2.1: crud
	Room getRoom(Integer roomId);
	Room createRoom(String roomName, Integer capacity);
	Room updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
	
	// 10.1.6: jpql
	List<Room> getAllRooms();
	List<Room> getRoomsByName(String roomName);

	// 10.1.5: relation
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	Room getRoomOfEquipment(Integer equipmentId);
}
