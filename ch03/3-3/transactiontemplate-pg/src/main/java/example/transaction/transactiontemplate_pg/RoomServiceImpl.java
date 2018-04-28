package example.transaction.transactiontemplate_pg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	TransactionTemplate transactionTemplate;
	@Autowired
	JdbcRoomDao	jdbcRoomDao;
	
	@Transactional(readOnly = true)
	@Override
	public Room getRoom(String roomId) {
		return jdbcRoomDao.getRoomWithEquipmentById(roomId);
	}

	@Override
	public void insertRoom(Room room) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				jdbcRoomDao.insertRoom(room);
				List<Equipment> equipmentList = room.getEquipmentList();
				for(Equipment item: equipmentList) {
					jdbcRoomDao.insertEquipment(item);
				}
			}
		});
	}

}
