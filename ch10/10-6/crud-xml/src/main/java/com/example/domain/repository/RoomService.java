package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Room;

public interface RoomService {
	Room getRoom(Integer id);
	List<Room> getAllRooms();
	Room createRoom(String roomName, Integer capacity);
	Room updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
}
