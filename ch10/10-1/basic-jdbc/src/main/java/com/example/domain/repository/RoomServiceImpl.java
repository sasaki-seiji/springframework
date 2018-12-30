package com.example.domain.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	JdbcRoomDao	jdbcRoomDao;
	
	@Transactional(readOnly = true)
	@Override
	public Room getRoom(String roomId) {
		return jdbcRoomDao.getRoomById(roomId);
	}

}
