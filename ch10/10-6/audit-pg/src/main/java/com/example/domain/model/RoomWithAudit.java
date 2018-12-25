package com.example.domain.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "room_with_audit")
@EntityListeners(AuditingEntityListener.class)
public class RoomWithAudit implements Serializable {

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

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;
	
	@CreatedDate
	@Column(name = "created_date")
	private LocalTime createdDate;
	
	@LastModifiedBy
	@Column(name = "last_modified_by")
	private String lastModifiedBy;
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalTime lastModifiedDate;
	
	public Integer getRoomId() { return this.roomId; }
	public void setRoomId(Integer id) { this.roomId = id; }
	
	public String getRoomName() { return this.roomName; }
	public void setRoomName(String name) { this.roomName = name; }
	
	public Integer getCapacity() { return this.capacity; }
	public void setCapacity(Integer capacity) { this.capacity = capacity; }

	public String getCreatedBy() { return this.createdBy; }
	public LocalTime getCreatedDate() { return this.createdDate;}
	public String getLastModifiedBy() { return this.lastModifiedBy; }
	public LocalTime getLastModifiedDate() { return this.lastModifiedDate; }
	
	public String toString() {
		return "{ roomId: " + roomId + ", roomName: " + roomName 
				+ ", capacity: " + capacity 
				+ ", createdBy: " + createdBy + ", createdDate: " + createdDate
				+ ", lastModifiedBy: " + lastModifiedBy 
				+ ", lastModifiedDate: " + lastModifiedDate + " }";
	}

}
