package example.jdbc.resultsetextractor;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String roomId;
	private String roomName;
	private Integer capacity;
	private List<Equipment> equipmentList = new ArrayList<Equipment>(); 
	
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
	public List<Equipment> getEquipmentList() { return this.equipmentList; }

	public String toString() {
		return "{ roomId: " + roomId + ", roomName: " + roomName + ", capacity: " + capacity + ", equipmentList: " + equipmentList + " }";
	}
}
