package example.transaction.platformtransactionmanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	PlatformTransactionManager txManager;
	
	@Autowired
	JdbcRoomDao	jdbcRoomDao;
	
	// use declarative transaction
	@Transactional(readOnly = true)
	@Override
	public Room getRoom(String roomId) {
		return jdbcRoomDao.getRoomWithEquipmentById(roomId);
	}

	// use explicit transaction
	@Override
	public void insertRoom(Room room) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("InsertRoomWithEquipmentTx");
		def.setReadOnly(false);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		try {
			jdbcRoomDao.insertRoom(room);
			List<Equipment> equipmentList = room.getEquipmentList();
			for(Equipment item: equipmentList) {
				jdbcRoomDao.insertEquipment(item);
			}
		} catch(Exception e) {
			txManager.rollback(status);
			throw new DataAccessException("error occurred by insert room", e) {
				private static final long serialVersionUID = 1L; 
			};
		}
		txManager.commit(status);
	}

}
