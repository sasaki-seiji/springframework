package com.example.domain.mapper;

import java.util.List;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomMapper {
	MeetingRoom findOne(String roomId);
	long count();
	List<MeetingRoom> findAll();
}
