package example.dataaccessexception.custom_error_codes;

public interface RoomService {
	// access Room with Equipments
	Room getRoom(String roomId);
	void insertRoom(Room room);
	
	// access only Room
	Room getRoomForUpdate(String roomId);
	void updateRoom(Room room);
}
