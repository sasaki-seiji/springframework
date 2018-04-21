package example.transaction.platformtransactionmanager;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
}
