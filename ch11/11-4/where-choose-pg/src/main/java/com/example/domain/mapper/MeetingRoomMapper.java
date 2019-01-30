package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

public interface MeetingRoomMapper {
	// 11.3.5: select
	MeetingRoom findOne(String roomId);
	long count();
	List<MeetingRoom> findAll();
	
	// 11.3.6: insert
	void create(MeetingRoom meetingRoom);

	// 11.3.7: update
	boolean update(MeetingRoom meetingRoom);
	
	// 11.3.8: delete
	boolean delete(String roomId);
	
	// 11.4.1: dynamic SQL building on mapping file
	List<MeetingRoom> findByCriteria(MeetingRoomCriteria criteria);
	List<MeetingRoom> findByCapacityClass(@Param("capacityClass") String capacityClass);
}
