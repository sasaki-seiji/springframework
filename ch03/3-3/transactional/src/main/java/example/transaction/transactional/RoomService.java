package example.transaction.transactional;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
}
