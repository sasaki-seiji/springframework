package example.jdbc.beanpropertyrowmapper_pg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		RowMapper<Room> rowMapper = new BeanPropertyRowMapper<Room>(Room.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, roomId);
	}
	
	public List<Room> getAllRoom() {
		String sql = "SELECT room_id, room_name, capacity FROM room";
		RowMapper<Room> rowMapper = new BeanPropertyRowMapper<Room>(Room.class);
		return jdbcTemplate.query(sql, rowMapper);
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
