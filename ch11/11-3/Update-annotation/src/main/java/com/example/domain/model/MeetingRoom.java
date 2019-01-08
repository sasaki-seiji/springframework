package com.example.domain.model;

public class MeetingRoom {
	private String roomId;
	private String roomName;
	private int capacity;
	
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String id) { this.roomId = id; }
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String name) { this.roomName = name; }
	public int getCapacity() { return this.capacity; }
	public void setCapacity(int capacity) { this.capacity = capacity; }

	public String toString() {
		return "{ roomId: " + this.roomId
				+ ", roomName: " + this.roomName
				+ ", capacity: " + this.capacity + " }";
	}
}
