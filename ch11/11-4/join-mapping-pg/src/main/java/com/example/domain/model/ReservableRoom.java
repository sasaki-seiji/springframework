package com.example.domain.model;

import java.time.LocalDate;

public class ReservableRoom {

	private String roomId;
	private LocalDate reservedDate;
	
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String id) { this.roomId = id; }
	public LocalDate getReservedDate() { return this.reservedDate; }
	public void setReservedDate(LocalDate date) { this.reservedDate = date; }
	
	public String toString() {
		return "{ roomId: " + roomId + ", reservedDate: " + reservedDate + " }";
	}
}
