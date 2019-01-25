package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomMapper {

	// 11.3.5: select

	@Select("SELECT room_id AS roomId, room_name AS roomName, capacity"
			+ " FROM meeting_room_serial WHERE room_id = #{roomId}")
	MeetingRoom findOne(Integer roomId);

	@Select("SELECT COUNT(*) FROM meeting_room")
	long count();

	@Select("SELECT room_id AS roomId, room_name AS roomName, capacity"
			+ " FROM meeting_room_serial ORDER BY room_id")
	List<MeetingRoom> findAll();
	
	// 11.3.6: insert
	
	@Options(useGeneratedKeys = true, keyProperty = "roomId")
	@Insert("INSERT INTO meeting_room_serial (room_name, capacity)"
			+ " VALUES (#{roomName}, #{capacity})")
	void create(MeetingRoom meetingRoom);
}
