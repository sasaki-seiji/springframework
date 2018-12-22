package com.example.domain.repository;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository	roomRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Room getRoom(Integer id) {
		// 2018.12.22 change
		// see https://stackoverflow.com/questions/49316751/spring-data-jpa-findone-change-to-optional-how-to-use-this
		//Room room = roomRepository.findOne(id);
		Optional<Room> room = roomRepository.findById(id);
		return room.orElseThrow(() -> new RuntimeException("not found room with specified id"));
	}

	@Transactional(readOnly = true)
	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll(new Sort(Direction.ASC, "roomId"));
	}

	@Transactional
	@Override
	public Room createRoom(String roomName, Integer capacity) {
		Room room = new Room();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		return roomRepository.save(room);
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
		// 2018.12.22 change
		//roomRepository.delete(id);
		roomRepository.deleteById(id);
	}

}
