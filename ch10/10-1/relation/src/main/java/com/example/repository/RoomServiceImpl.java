package com.example.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Equipment;
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

	@Transactional(readOnly = true)
	@Override
	public List<Equipment> getEquipmentsInRoom(Integer roomId) {
		Room room = entityManager.find(Room.class, roomId);
		return room.getEquipments();
	}

	@Transactional(readOnly = true)
	@Override
	public Room getRoomOfEquipment(Integer equipmentId) {
		Equipment equipment = entityManager.find(Equipment.class, equipmentId);
		return equipment.getRoom();
	}
}
