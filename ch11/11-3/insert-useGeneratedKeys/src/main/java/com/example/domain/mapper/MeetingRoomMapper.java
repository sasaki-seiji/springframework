package com.example.domain.mapper;

import java.util.List;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomMapper {
	// 11.3.5: select
	MeetingRoom findOne(Integer roomId);
	long count();
	List<MeetingRoom> findAll();
	
	// 11.3.6: insert
	void create(MeetingRoom meetingRoom);
}
