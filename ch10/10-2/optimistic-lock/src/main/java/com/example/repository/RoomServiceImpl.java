package com.example.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room_with_version;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@PersistenceContext
	EntityManager	entityManager;

	// 10.2.3: optimistic lock

	@Transactional
	@Override
	public void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity) {
		Room_with_version room = entityManager.find(Room_with_version.class, id);
		entityManager.lock(room, LockModeType.OPTIMISTIC);
		room.setRoomName(roomName);
		room.setCapacity(capacity);
	}

	// 10.2.1: CRUD operations with JPA
	
	@Transactional(readOnly = true)
	@Override
	public Room_with_version getRoom(Integer roomId) {
		Room_with_version room = entityManager.find(Room_with_version.class, roomId);
		if (room == null) {
			throw new RuntimeException("not found room with specified id");
		}
		return room;
	}

}
