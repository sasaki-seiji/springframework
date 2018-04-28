package example.transaction.platformtransactionmanager_pg;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
}
