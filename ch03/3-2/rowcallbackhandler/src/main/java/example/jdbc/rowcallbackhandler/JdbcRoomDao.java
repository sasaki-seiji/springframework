package example.jdbc.rowcallbackhandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

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
		RoomRowMapper rowMapper = new RoomRowMapper();
		return jdbcTemplate.queryForObject(sql, rowMapper, roomId);
	}
	
	public List<Room> getAllRoom() {
		String sql = "SELECT room_id, room_name, capacity FROM room";
		RoomRowMapper rowMapper = new RoomRowMapper();
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

	// use RowCallbackHander
	public void reportRooms() throws IOException {
		File csvFile = File.createTempFile("room_", ".csv");
		System.out.println("path: " + csvFile.getPath());
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(csvFile), StandardCharsets.UTF_8.name()))) {
			String sql = "SELECT room_id, room_name, capacity FROM room ORDER BY room_id";
			RoomRowCallbackHandler handler = new RoomRowCallbackHandler(writer);
			jdbcTemplate.query(sql, handler);
		}
	}
}
