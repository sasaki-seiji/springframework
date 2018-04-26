package example.jdbc.update_pg;

public class Room {
	private String roomId;
	private String roomName;
	private Integer capacity;
	
	public Room(String roomId, String roomName, Integer capacity) {
		this.roomId = roomId; this.roomName = roomName; this.capacity = capacity;
	}
	public Room() {}
	
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String roomId) { this.roomId = roomId; }
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String roomName) { this.roomName = roomName; }
	public Integer getCapacity() { return this.capacity; }
	public void setCapacity(Integer capacity) { this.capacity = capacity; }

	public String toString() {
		return "{ roomId: " + roomId + ", roomName: " + roomName + ", capacity: " + capacity + " }";
	}
}
