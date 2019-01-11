package com.example.domain.model;

public class MeetingRoomCriteria {

	private String roomId;
	private String roomName;
	private Integer capacity;
	
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String id) { this.roomId = id; }
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String name) { this.roomName = name; }
	public Integer getCapacity() { return this.capacity; }
	public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
