package com.example.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "room_with_version")
public class Room_with_version implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// 2018.12.17 modify: Sequence "HIBERNATE_SEQUENCE" not found
	// see https://stackoverflow.com/questions/39807483/sequence-hibernate-sequence-not-found-sql-statement
	//@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Integer roomId;
	
	@Column(name = "room_name")
	private String roomName;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	// 2018.12.19 add
	@Version
	@Column(name = "version")
	private Integer version;
	
	public Integer getRoomId() { return this.roomId; }
	public void setRoomId(Integer id) { this.roomId = id; }
	
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String name) { this.roomName = name; }
	
	public Integer getCapacity() { return this.capacity; }
	public void setCapacity(Integer capacity) { this.capacity = capacity; }

	public String toString() {
		return "{ roomId: " + roomId + ", roomName: " + roomName 
				+ ", capacity: " + capacity + ", version: " + version + " }";
	}
}
