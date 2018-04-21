package example.transaction.platformtransactionmanager;

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
	
	public Room getRoomWithEquipmentById(String roomId) {
		String sql = "SELECT r.room_id, r.room_name, r.capacity,"
				+ " e.equipment_id, e.equipment_name, e.equipment_count,"
				+ " e.equipment_remarks FROM room r LEFT JOIN equipment e"
				+ " ON r.room_id = e.room_id WHERE r.room_id = ?";
		RoomListResultSetExtractor extractor = new RoomListResultSetExtractor();
		List<Room> roomList = jdbcTemplate.query(sql, extractor, roomId);
		return roomList.get(0);
	}
	
	public List<Room> getAllRoom() {
		String sql = "SELECT room_id, room_name, capacity FROM room";
		RoomRowMapper rowMapper = new RoomRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Room> getAllRoomWithEquipment() {
		String sql = "SELECT r.room_id, r.room_name, r.capacity,"
				+ " e.equipment_id, e.equipment_name, e.equipment_count,"
				+ " e.equipment_remarks FROM room r LEFT JOIN equipment e"
				+ " ON r.room_id = e.room_id";
		RoomListResultSetExtractor extractor = new RoomListResultSetExtractor();
		return jdbcTemplate.query(sql, extractor);
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

	public int insertEquipment(Equipment equipment) {
		String sql = "INSERT INTO equipment("
				+ " equipment_id, room_id, equipment_name,"
				+ " equipment_count, equipment_remarks)"
				+ " VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, 
				equipment.getEquipmentId(), equipment.getRoomId(),
				equipment.getEquipmentName(), equipment.getEquipmentCount(),
				equipment.getEquipmentRemarks());
	}

}
