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
import com.example.domain.model.Room;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@PersistenceContext
	EntityManager	entityManager;

	// 10.2.3: optimistic lock

	@Transactional
	@Override
	public void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity) {
		Room room = entityManager.find(Room.class, id);
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
	public List<Room> getRoomsByNameFetch(String roomName) {
		String jpql = "SELECT DISTINCT r FROM Room r LEFT JOIN FETCH r.equipments"
					+ " WHERE r.roomName = :roomName";
		TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
		query.setParameter("roomName", roomName);
		return query.getResultList();
	}

	// 10.2.1: CRUD operations with JPA
	
	@Transactional(readOnly = true)
	@Override
	public Room getRoom(Integer roomId) {
		Room room = entityManager.find(Room.class, roomId);
		if (room == null) {
			throw new RuntimeException("not found room with specified id");
		}
		return room;
	}

	@Transactional
	@Override
	public Room createRoom(String roomName, Integer capacity) {
		Room room = new Room();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		entityManager.persist(room);
		return room;
	}

	@Transactional
	@Override
	public Room updateRoomName(Integer id, String roomName) {
		Room room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

	@Transactional
	@Override
	public void deleteRoom(Integer id) {
		Room room = getRoom(id);
		entityManager.remove(room);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Room> getAllRooms() {
		String jpql = "SELECT r FROM Room r";
		TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
		return query.getResultList();
	}

	// 10.1.6: JPQL

	@Transactional(readOnly = true)
	@Override
	public List<Room> getRoomsByName(String roomName) {
		String jpql = "SELECT r FROM Room r WHERE r.roomName = :roomName";
		TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
		query.setParameter("roomName", roomName);
		return query.getResultList();
	}

	// 10.1.5: relation

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
