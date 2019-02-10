package com.example.domain.mapper;

import java.util.List;


import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

public interface MeetingRoomMapper {
	// 11.3.5: select
	MeetingRoom findOne(String roomId);
	long count();
	List<MeetingRoom> findAll();
	
	// 11.3.6: insert
	void create(MeetingRoom meetingRoom);

	// 11.3.7: update
	
	// 11.3.8: delete
	boolean delete(String roomId);
	
	// 11.4.1: dynamic SQL building on mapping file
	List<MeetingRoom> findByCriteria(MeetingRoomCriteria criteria);
	List<MeetingRoom> findByCapacityClass(@Param("capacityClass") String capacityClass);
	List<MeetingRoom> findByRoomIds(List<String> roomIds);
	boolean update(MeetingRoom meetingRoom);
	
	// 11.4.4: RowBounds
	List<MeetingRoom> findAll(RowBounds rowBounds);

	// 11.4.5: ResultHandler
	void collectAll(ResultHandler<MeetingRoom> resultHandler);
}
