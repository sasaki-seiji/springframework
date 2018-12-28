package com.example.domain.repository;


import com.example.domain.model.Room_with_version;

public interface RoomService {
	// 10.2.3: optimistic lock
	void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity);
	
	// 10.2.1: CRUD operations with JPA
	Room_with_version getRoom(Integer roomId);
}
