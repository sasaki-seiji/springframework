package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomMapper {
	@Select("SELECT room_id AS roomId, room_name AS roomName, capacity"
			+ " FROM meeting_room WHERE room_id = #{roomId}")
	MeetingRoom findOne(String roomId);
	
	@Select("SELECT COUNT(*) FROM meeting_room")
	long count();
	
	@Select("SELECT room_id AS roomId, room_name AS roomName, capacity"
			+ " FROM meeting_room ORDER BY room_id")
	List<MeetingRoom> findAll();
}
