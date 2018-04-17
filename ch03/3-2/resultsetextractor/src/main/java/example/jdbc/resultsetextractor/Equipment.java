package example.jdbc.resultsetextractor;

public class Equipment {
	private String equipmentId;
	private String roomId;
	private String equipmentName;
	private Integer equipmentCount;
	private String equipmentRemarks;
	
	String getEquipmentId() { return this.equipmentId; }
	void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }
	String getRoomId() { return this.roomId; }
	void setRoomId(String roomId) { this.roomId = roomId; }
	String getEquipmentName() { return this.equipmentName; }
	void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }
	Integer getEquipmentCount() { return this.equipmentCount; }
	void setEquipmentCount(Integer equipmentCount) { this.equipmentCount = equipmentCount; }
	String getEquipmentRemarks() { return this.equipmentRemarks; }
	void setEquipmentRemarks(String equipmentRemarks) { this.equipmentRemarks = equipmentRemarks; }
	
	public String toString() {
		return "{ equipmentId: " + equipmentId + ", roomId: " + roomId
				+ ", equipmentName: " + equipmentName + ", equipmentCount: " + equipmentCount
				+ ", equipmentRemaks: " + equipmentRemarks + " }";
	}
}
