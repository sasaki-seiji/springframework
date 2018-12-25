package com.example.domain.repository;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.RoomWithAudit;

@Service("roomWithAuditService")
public class RoomWithAuditServiceImpl implements RoomWithAuditService {

	@Autowired
	RoomWithAuditRepository	roomWithAuditRepository;
	
	@Transactional(readOnly = true)
	@Override
	public RoomWithAudit getRoomWithAudit(Integer id) {
		Optional<RoomWithAudit> room = roomWithAuditRepository.findById(id);
		return room.orElseThrow(() -> new RuntimeException("not found room with specified id"));
	}

	@Transactional(readOnly = true)
	@Override
	public List<RoomWithAudit> getAllRoomsWithAudit() {
		return roomWithAuditRepository.findAll(new Sort(Direction.ASC, "roomId"));
	}

	@Transactional
	@Override
	public RoomWithAudit createRoomWithAudit(String roomName, Integer capacity) {
		RoomWithAudit room = new RoomWithAudit();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		return roomWithAuditRepository.save(room);
	}

	@Transactional
	@Override
	public RoomWithAudit updateRoomName(Integer id, String roomName) {
		RoomWithAudit room = getRoomWithAudit(id);
		room.setRoomName(roomName);
		return room;
	}

	@Transactional
	@Override
	public void deleteRoomWithAudit(Integer id) {
		roomWithAuditRepository.deleteById(id);
	}

}
