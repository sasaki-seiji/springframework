package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

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
	
	// 11.3.8: delete
	boolean delete(String roomId);
	
	// 11.4.1: dynamic SQL building on mapping file
	List<MeetingRoom> findByCapacityClass(@Param("capacityClass") String capacityClass);
	List<MeetingRoom> findByRoomIds(List<String> roomIds);
	boolean update(MeetingRoom meetingRoom);

	// 11.4.2: SQL builder class

	@SelectProvider(type = MeetingRoomSqlProvider.class, method = "findByCriteria")
	List<MeetingRoom> findByCriteria(MeetingRoomCriteria criteria);
	
	class MeetingRoomSqlProvider {
		
		public String findByCriteria(final MeetingRoomCriteria criteria) {
			return new SQL() {{
				SELECT("room_id AS roomId, room_name AS roomName, capacity");
				FROM("meeting_room");
				if (criteria.getRoomId() != null) {
					WHERE("room_id like #{roomId} || '%'");
				}
				if (criteria.getRoomName() != null) {
					WHERE("room_name like #{roomName} || '%'");
				}
				if (criteria.getCapacity() != null) {
					WHERE("capacity >= #{capacity}");
				}
				ORDER_BY("room_id");
			}}.toString();
		}
	}
}
