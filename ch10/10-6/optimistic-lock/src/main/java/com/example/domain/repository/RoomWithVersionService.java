package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.RoomWithVersion;

public interface RoomWithVersionService {
	// 10.6.3: optimistic lock
	void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity);

	// 10.6.1: crud
	RoomWithVersion getRoom(Integer id);
	List<RoomWithVersion> getAllRooms();
	RoomWithVersion createRoom(String roomName, Integer capacity);
	RoomWithVersion updateRoomName(Integer id, String roomName);
	void deleteRoom(Integer id);
}
