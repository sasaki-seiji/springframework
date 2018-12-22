package com.example.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room implements Serializable {

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
	
	// 2018.12.16 change: org.hibernate.LazyInitializationException
	//@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Equipment> equipments = new ArrayList<Equipment>();
	
	public List<Equipment> getEquipments() { return this.equipments; }
	
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
