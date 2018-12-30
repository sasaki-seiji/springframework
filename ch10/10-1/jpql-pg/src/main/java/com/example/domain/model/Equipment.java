package com.example.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "equipment_id")
	private Integer equipmentId;

	@Column(name = "equipment_name")
	private String equipmentName;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@Column(name = "equipment_count")
	private Integer equipmentCount;
	
	@Column(name = "equipment_remarks")
	private String equipmentRemarks;
	
	public Room getRoom() { return this.room; }
	
	public Integer getEquipmentId() { return this.equipmentId; }
	public void setEquipmentId(Integer id) { this.equipmentId = id; }
	
	public String getEquipmentName() { return this.equipmentName; }
	public void setEquipmentName(String name) { this.equipmentName = name; }
	
	public Integer getEquipmentCount() { return this.equipmentCount; }
	public void setEquipmentCount(Integer count) { this.equipmentCount = count; }
	
	public String getEquipmentRemarks() { return this.equipmentRemarks; }
	public void setEquipmentRemarks(String remarks) { this.equipmentRemarks = remarks; }

	public String toString() {
		return "{ equipmentId: " + this.equipmentId 
				+ ", equipmentName: " + this.equipmentName 
				+ ", equipmentCount: " + this.equipmentCount 
				+ ", equipmentRemarks: " + this.equipmentRemarks + " }";
	}
}
