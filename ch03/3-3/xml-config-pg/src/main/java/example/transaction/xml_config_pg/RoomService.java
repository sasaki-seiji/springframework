package example.transaction.xml_config_pg;

public interface RoomService {
	Room getRoom(String roomId);
	void insertRoom(Room room);
}
