package example.jdbc.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcRoomDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int findMaxCapacity() {
		String sql = "SELECT MAX(capacity) FROM room";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String findRoomNameById(String roomId) {
		String sql = "SELECT room_name FROM room WHERE room_id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, roomId);
	}
	
	public Room getRoomById(String roomId) {
		String sql = "SELECT room_id, room_name, capacity FROM room WHERE room_id = ?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, roomId);
		Room room = new Room();
		room.setRoomId((String)result.get("room_id"));
		room.setRoomName((String)result.get("room_name"));
		room.setCapacity((Integer)result.get("capacity"));
		return room;
	}
	
	public List<Room> getAllRoom() {
		String sql = "SELECT room_id, room_name, capacity FROM room";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Room> roomList = new ArrayList<Room>();
		for(Map<String, Object> result: resultList) {
			Room room = new Room();
			room.setRoomId((String)result.get("room_id"));
			room.setRoomName((String)result.get("room_name"));
			room.setCapacity((Integer)result.get("capacity"));
			roomList.add(room);
		}
		return roomList;
	}
	
	public int insertRoom(Room room) {
		String sql = "INSERT INTO room(room_id, room_name, capacity)"
				+ " VALUES(?, ?, ?)";
		return jdbcTemplate.update(sql, room.getRoomId(), 
				room.getRoomName(), room.getCapacity());
	}

	public int updateRoomById(Room room) {
		String sql = "UPDATE room SET room_name = ?, capacity = ?"
				+ " WHERE room_id = ?";
		return jdbcTemplate.update(sql,	room.getRoomName(), 
				room.getCapacity(), room.getRoomId());
	}

	public int deleteRoomById(String roomId) {
		String sql = "DELETE FROM room WHERE room_id = ?";
		return jdbcTemplate.update(sql,	roomId);
	}

}
