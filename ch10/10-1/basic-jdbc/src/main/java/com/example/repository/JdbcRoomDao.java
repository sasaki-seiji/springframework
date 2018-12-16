package com.example.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.domain.model.Room;

@Component
public class JdbcRoomDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Room getRoomById(String roomId) {
		String sql = "SELECT room_id, room_name, capacity FROM room WHERE room_id = ?";
		RowMapper<Room> rowMapper = new BeanPropertyRowMapper<Room>(Room.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, roomId);
	}

}
