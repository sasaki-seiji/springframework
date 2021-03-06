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
	
	public Integer getRoomId() { return this.roomId; }
	public void setRoomId(Integer id) { this.roomId = id; }
	
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String name) { this.roomName = name; }
	
	public Integer getCapacity() { return this.capacity; }
	public void setCapacity(Integer capacity) { this.capacity = capacity; }

	public String toString() {
		return "{ roomId: " + roomId + ", roomName: " + roomName + ", capacity: " + capacity + " }";
	}
}
