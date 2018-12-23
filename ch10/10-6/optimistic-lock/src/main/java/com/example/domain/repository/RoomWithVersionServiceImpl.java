package com.example.domain.repository;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.RoomWithVersion;

@Service("roomService")
public class RoomWithVersionServiceImpl implements RoomWithVersionService {

	@Autowired
	RoomWithVersionRepository	roomWithVersionRepository;

	// 10.6.3: optimistic lock

	@Transactional
	@Override
	public void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity) {
		RoomWithVersion room = getRoom(id);
		room.setRoomName(roomName);
		room.setCapacity(capacity);
	}

	// 10.6.1: crud
	
	@Transactional(readOnly = true)
	@Override
	public RoomWithVersion getRoom(Integer id) {
		// 2018.12.22 change
		// see https://stackoverflow.com/questions/49316751/spring-data-jpa-findone-change-to-optional-how-to-use-this
		//Room room = roomRepository.findOne(id);
		Optional<RoomWithVersion> room = roomWithVersionRepository.findById(id);
		return room.orElseThrow(() -> new RuntimeException("not found room with specified id"));
	}

	@Transactional(readOnly = true)
	@Override
	public List<RoomWithVersion> getAllRooms() {
		return roomWithVersionRepository.findAll(new Sort(Direction.ASC, "roomId"));
	}

	@Transactional
	@Override
	public RoomWithVersion createRoom(String roomName, Integer capacity) {
		RoomWithVersion room = new RoomWithVersion();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		return roomWithVersionRepository.save(room);
	}

	@Transactional
	@Override
	public RoomWithVersion updateRoomName(Integer id, String roomName) {
		RoomWithVersion room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

	@Transactional
	@Override
	public void deleteRoom(Integer id) {
		// 2018.12.22 change
		//roomRepository.delete(id);
		roomWithVersionRepository.deleteById(id);
	}

}
