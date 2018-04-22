package example.dataaccessexception.handle_exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	JdbcRoomDao	jdbcRoomDao;
	
	@Transactional(readOnly = true)
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
	
	@Transactional(readOnly = true)
	@Override
	public Room getRoomForUpdate(String roomId) {
		Room room = null;
		try {
			room = jdbcRoomDao.getRoomById(roomId);
		} catch(DataRetrievalFailureException e) {
			throw new NotFoundRoomIdException("roomId=" + roomId, e);
		}
		return room;
	}

	@Override
	public void updateRoom(Room room) {
		jdbcRoomDao.updateRoomById(room);
	}
}
