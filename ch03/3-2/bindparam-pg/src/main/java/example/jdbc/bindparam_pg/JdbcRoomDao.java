package example.jdbc.bindparam_pg;

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
}
