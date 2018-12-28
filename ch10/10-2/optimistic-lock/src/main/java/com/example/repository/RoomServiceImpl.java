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

	// 10.2.2: update JPQL

	@Transactional
	@Override
	public Integer updateCapacityAll(Integer capacity) {
		String jpql = "UPDATE Room r SET r.capacity = :capacity";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("capacity", capacity);
		return query.executeUpdate();
	}

	// 10.2.2: JOIN FETCH

	@Transactional(readOnly = true)
	@Override
	public List<Room_with_version> getRoomsByNameFetch(String roomName) {
		String jpql = "SELECT DISTINCT r FROM Room r LEFT JOIN FETCH r.equipments"
					+ " WHERE r.roomName = :roomName";
		TypedQuery<Room_with_version> query = entityManager.createQuery(jpql, Room_with_version.class);
		query.setParameter("roomName", roomName);
		return query.getResultList();
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

	@Transactional
	@Override
	public Room_with_version createRoom(String roomName, Integer capacity) {
		Room_with_version room = new Room_with_version();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		entityManager.persist(room);
		return room;
	}

	@Transactional
	@Override
	public Room_with_version updateRoomName(Integer id, String roomName) {
		Room_with_version room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

	@Transactional
	@Override
	public void deleteRoom(Integer id) {
		Room_with_version room = getRoom(id);
		entityManager.remove(room);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Room_with_version> getAllRooms() {
		String jpql = "SELECT r FROM Room r";
		TypedQuery<Room_with_version> query = entityManager.createQuery(jpql, Room_with_version.class);
		return query.getResultList();
	}

	// 10.1.6: JPQL

	@Transactional(readOnly = true)
	@Override
	public List<Room_with_version> getRoomsByName(String roomName) {
		String jpql = "SELECT r FROM Room r WHERE r.roomName = :roomName";
		TypedQuery<Room_with_version> query = entityManager.createQuery(jpql, Room_with_version.class);
		query.setParameter("roomName", roomName);
		return query.getResultList();
	}

	// 10.1.5: relation

	@Transactional(readOnly = true)
	@Override
	public List<Equipment> getEquipmentsInRoom(Integer roomId) {
		Room_with_version room = entityManager.find(Room_with_version.class, roomId);
		return room.getEquipments();
	}

	@Transactional(readOnly = true)
	@Override
	public Room_with_version getRoomOfEquipment(Integer equipmentId) {
		Equipment equipment = entityManager.find(Equipment.class, equipmentId);
		return equipment.getRoom();
	}

}
