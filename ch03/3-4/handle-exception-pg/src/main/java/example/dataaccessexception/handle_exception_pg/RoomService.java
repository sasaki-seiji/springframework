package example.dataaccessexception.handle_exception_pg;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
	Room getRoomForUpdate(String roomId);
	void updateRoom(Room room);
}
