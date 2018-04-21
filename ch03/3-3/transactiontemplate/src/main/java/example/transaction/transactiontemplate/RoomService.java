package example.transaction.transactiontemplate;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
}
