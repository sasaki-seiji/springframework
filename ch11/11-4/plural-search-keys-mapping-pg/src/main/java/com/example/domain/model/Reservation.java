package com.example.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {

	private String reserationId;
	private String roomId;
	private LocalDate reservedDate;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public String getReservationId() { return this.reserationId; }
	public void setReservationId(String id) { this.reserationId = id; }
	public String getRoomId() { return this.roomId; }
	public void setRoomId(String id) { this.roomId = id; }
	public LocalDate getReservedDate() { return this.reservedDate; }
	public void setReservedDate(LocalDate date) { this.reservedDate = date; }
	public LocalTime getStartTime() { return this.startTime; }
	public void setStartTime(LocalTime time) { this.startTime = time; }
	public LocalTime getEndTime() { return this.endTime; }
	public void setEndTime(LocalTime time) { this.endTime = time; }
	
	public String toString() {
		return "{ rservationId: " + this.reserationId 
				+ ", roomId: " + this.roomId
				+ ", reservedDate: " + this.reservedDate
				+ ", startTime: " + this.startTime
				+ ", endTime: " + this.endTime + " }";
	}
}
