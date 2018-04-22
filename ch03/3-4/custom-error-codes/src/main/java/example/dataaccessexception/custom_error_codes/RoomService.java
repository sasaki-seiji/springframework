package example.dataaccessexception.custom_error_codes;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
	Room getRoomForUpdate(String roomId);
	void updateRoom(Room room);
}
