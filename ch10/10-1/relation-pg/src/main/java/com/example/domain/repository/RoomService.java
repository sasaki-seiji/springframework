package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

public interface RoomService {
	// 10.1.1: basic-jpa
	Room getRoomById(Integer roomId);
	
	// 10.1.5: relation
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	Room getRoomOfEquipment(Integer equipmentId);
}
