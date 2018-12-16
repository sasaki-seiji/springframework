package com.example.repository;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

public interface RoomService {
	Room getRoom(Integer roomId);
	Room createRoom(String roomName, Integer capacity);
	Room updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
	List<Room> getAllRooms();
	
	List<Room> getRoomsByName(String roomName);
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	Room getRoomOfEquipment(Integer equipmentId);
}
