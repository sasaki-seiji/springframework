package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomMapper {
	@Results({
		@Result(column = "room_id", property = "roomId", id = true),
		@Result(column = "room_name", property = "roomName")
	})
	@Select("SELECT room_id, room_name, capacity"
			+ " FROM meeting_room WHERE room_id = #{roomId}")
	MeetingRoom findOne(String roomId);
	
	@Select("SELECT COUNT(*) FROM meeting_room")
	long count();
	
	@Results({
		@Result(column = "room_id", property = "roomId", id = true),
		@Result(column = "room_name", property = "roomName")
	})
	@Select("SELECT room_id, room_name, capacity"
			+ " FROM meeting_room ORDER BY room_id")
	List<MeetingRoom> findAll();
}
