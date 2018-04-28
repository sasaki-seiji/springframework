package example.transaction.xml_config_pg;

import java.util.List;


public class RoomServiceImpl implements RoomService {

	private JdbcRoomDao	jdbcRoomDao;
	public void setJdbcRoomDao(JdbcRoomDao jdbcRoomDao) {
		this.jdbcRoomDao = jdbcRoomDao;
	}
	
	@Override
	public Room getRoom(String roomId) {
		return jdbcRoomDao.getRoomWithEquipmentById(roomId);
	}

	@Override
	public void insertRoom(Room room) {
		jdbcRoomDao.insertRoom(room);
		List<Equipment> equipmentList = room.getEquipmentList();
		for(Equipment item: equipmentList) {
			jdbcRoomDao.insertEquipment(item);
		}
	}

}
