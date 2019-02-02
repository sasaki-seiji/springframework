package com.example.domain.model;

import java.util.List;

public class MeetingRoom {
	private String roomId;
	private String roomName;
	private int capacity;
	
	// 2019.01.12 add
	private List<ReservableRoom> reservableRooms;
	
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String id) { this.roomId = id; }
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String name) { this.roomName = name; }
	public int getCapacity() { return this.capacity; }
	public void setCapacity(int capacity) { this.capacity = capacity; }

	// 2019.01.12 add
	public List<ReservableRoom> getReservableRooms() { return this.reservableRooms; }
	public void setReservableRooms(List<ReservableRoom> reservableRooms) { 
		this.reservableRooms = reservableRooms; 
	}

	// 2019.01.12 add reservaleRooms
	public String toString() {
		return "{ roomId: " + this.roomId
				+ ", roomName: " + this.roomName
				+ ", capacity: " + this.capacity 
				+ ", reservableRooms: " + this.reservableRooms + " }";
	}
}
