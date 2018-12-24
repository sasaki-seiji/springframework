package com.example.domain.repository;

public class RoomCriteria {

	private String roomNameLike;
	private Integer capacityMin;
	private Integer capacityMax;
	
	public String getRoomNameLike() { return this.roomNameLike; }
	public void setRoomNameLike(String like) { this.roomNameLike = like; }
	public Integer getCapacityMin() { return this.capacityMin; }
	public void setCapacityMin(Integer min) { this.capacityMin = min; }
	public Integer getCapacityMax() { return this.capacityMax; }
	public void setCapacityMax(Integer max) { this.capacityMax = max; }
}
