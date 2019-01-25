package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomMapper {

	// 11.3.5: select

	@Select("SELECT room_id AS roomId, room_name AS roomName, capacity"
			+ " FROM meeting_room WHERE room_id = #{roomId}")
	MeetingRoom findOne(String roomId);

	@Select("SELECT COUNT(*) FROM meeting_room")
	long count();

	@Select("SELECT room_id AS roomId, room_name AS roomName, capacity"
			+ " FROM meeting_room ORDER BY room_id")
	List<MeetingRoom> findAll();
	
	// 11.3.6: insert
	
	@SelectKey(statement = "SELECT GEN_RANDOM_UUID()", keyProperty = "roomId", 
			before = true, resultType = String.class)	
	@Insert("INSERT INTO meeting_room (room_id, room_name, capacity)"
			+ " VALUES (#{roomId}, #{roomName}, #{capacity})")
	void create(MeetingRoom meetingRoom);
}
