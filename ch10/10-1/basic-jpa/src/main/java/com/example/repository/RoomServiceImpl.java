package com.example.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@PersistenceContext
	EntityManager	entityManager;
	
	@Transactional(readOnly = true)
	@Override
	public Room getRoomById(Integer roomId) {
		return entityManager.find(Room.class, roomId);
	}
}
