package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Room;

public interface RoomService {
	// 10.6.1: crud
	Room getRoom(Integer id);
	List<Room> getAllRooms();
	Room createRoom(String roomName, Integer capacity);
	Room updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
	
	// 10.6.2: jpql using @Query annotation
	List<Room> findByRoomName(String roomName);
	Integer updateCapacityAll(Integer capacity);
}
