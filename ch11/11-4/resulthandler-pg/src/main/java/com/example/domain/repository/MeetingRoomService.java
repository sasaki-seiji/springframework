package com.example.domain.repository;

import java.util.List;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.mapper.MeetingRoomMapper;
import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

@Transactional
@Service
public class MeetingRoomService {

	@Autowired
	MeetingRoomMapper meetingRoomMapper;

	// 11.3.5: select
	
	public MeetingRoom findOne(String roomId) {
		return meetingRoomMapper.findOne(roomId);
	}
	
	public long count() {
		return meetingRoomMapper.count();
	}
	
	public List<MeetingRoom> findAll() {
		return meetingRoomMapper.findAll();
	}

	// 11.3.6: insert
	
	public void create(MeetingRoom meetingRoom) {
		meetingRoomMapper.create(meetingRoom);
	}
	
	// 11.3.7: update
	
	// 11.3.8: delete
	
	public boolean delete(String roomId) {
		return meetingRoomMapper.delete(roomId);
	}

	// 11.4.1: dynamic SQL building on mapping file

	public List<MeetingRoom> findByCriteria(MeetingRoomCriteria criteria) {
		return meetingRoomMapper.findByCriteria(criteria);
	}

	public List<MeetingRoom> findByCapacityClass(String capacityClass) {
		return meetingRoomMapper.findByCapacityClass(capacityClass);
	}
	
	public List<MeetingRoom> findByRoomIds(List<String> roomIds) {
		return meetingRoomMapper.findByRoomIds(roomIds);
	}

	public boolean update(MeetingRoom meetingRoom) {
		return meetingRoomMapper.update(meetingRoom);
	}

	// 11.4.4: RowBounds

	public List<MeetingRoom> findAll(RowBounds rowBounds) {
		return meetingRoomMapper.findAll(rowBounds);
	}

	// 11.4.5: ResultHandler
	
	public void collectAll(ResultHandler<MeetingRoom> resultHandler) {
		meetingRoomMapper.collectAll(resultHandler);
	}
}
