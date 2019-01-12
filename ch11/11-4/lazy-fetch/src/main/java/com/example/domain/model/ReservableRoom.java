package com.example.domain.model;

import java.time.LocalDate;
import java.util.List;

public class ReservableRoom {

	private String roomId;
	private LocalDate reservedDate;
	
	// 2019.01.12 add
	private List<Reservation> reservations;
	
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String id) { this.roomId = id; }
	public LocalDate getReservedDate() { return this.reservedDate; }
	public void setReservedDate(LocalDate date) { this.reservedDate = date; }
	
	// 2019.01.12 add
	public List<Reservation> getReservations() { return this.reservations; }
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	// 2019.01.12 add reservations
	public String toString() {
		return "{ roomId: " + roomId + ", reservedDate: " + reservedDate 
				+ ", reservations: " + reservations + " }";
	}
}
