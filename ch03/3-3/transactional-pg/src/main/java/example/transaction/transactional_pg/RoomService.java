package example.transaction.transactional_pg;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
}
