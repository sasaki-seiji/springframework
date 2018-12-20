package com.example.pessimistic_lock;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PessimisticLockingFailureException;

import com.example.repository.RoomService;

public class RoomUpdater implements Runnable {

	private RoomService roomService;
	private Integer id;
	private String roomName;
	private Integer capacity;
	private int	count;
	private int success;
	private int failure;
	
	RoomUpdater(RoomService roomService, Integer id, String roomName, Integer capacity, int count) {
		this.roomService = roomService;
		this.id = id;
		this.roomName = roomName;
		this.capacity = capacity;
		this.count = count;
		this.success = this.failure = 0;
	}
	
	public int getSuccess() { return this.success; }
	public int getFailure() { return this.failure; }
	
	@Override
	public void run() {
		for (int i=0; i < count; i++) {
			try {
		   		roomService.updateRoomWithPessimisticLock(id, roomName, capacity);
		   		success++;
			}
			catch (PessimisticLockingFailureException e) {
				failure++;
			}
		}
	}

}
