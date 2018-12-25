package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.RoomWithAudit;

public interface RoomWithAuditService {
	RoomWithAudit getRoomWithAudit(Integer id);
	List<RoomWithAudit> getAllRoomsWithAudit();
	RoomWithAudit createRoomWithAudit(String roomName, Integer capacity);
	RoomWithAudit updateRoomName(Integer id, String roomName);
	void deleteRoomWithAudit(Integer id);
}
