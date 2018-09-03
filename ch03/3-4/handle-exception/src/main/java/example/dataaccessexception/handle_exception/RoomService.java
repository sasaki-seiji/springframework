package example.dataaccessexception.handle_exception;

public interface RoomService {
	// access Room with included Equipments
	Room getRoom(String roomId);
	void insertRoom(Room room);
	
	// access Room without included Equipments
	Room getRoomForUpdate(String roomId);
	void updateRoom(Room room);
}
