package example.jdbc.queryformap_pg;

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
}
