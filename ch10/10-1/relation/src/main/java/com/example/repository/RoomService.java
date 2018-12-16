package com.example.repository;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

public interface RoomService {
	Room getRoomById(Integer roomId);
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	Room getRoomOfEquipment(Integer equipmentId);
}
