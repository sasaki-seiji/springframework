package com.example.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "room_id")
	private Integer roomId;
	
	@Column(name = "room_name")
	private String roomName;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	Integer getRoomId() { return this.roomId; }
	void setRoomId(Integer id) { this.roomId = id; }
	
	String getRoomName() { return this.roomName; }
	void setRoomName(String name) { this.roomName = name; }
	
	Integer getCapacity() { return this.capacity; }
	void setCapacity(Integer capacity) { this.capacity = capacity; }

	public String toString() {
		return "{ roomId: " + roomId + ", roomName: " + roomName + ", capacity: " + capacity + " }";
	}
}
