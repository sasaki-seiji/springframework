package com.example.optimistic_lock;

import org.springframework.dao.OptimisticLockingFailureException;

import com.example.repository.RoomService;

public class RoomUpdater implements Runnable {

	private RoomService roomService;
	private Integer id;
	private String roomName;
	private Integer capacity;
	private int	count;
	private int success = 0;
	private int failure = 0;
	
	RoomUpdater(RoomService roomService, Integer id, String roomName, Integer capacity, int count) {
		this.roomService = roomService;
		this.id = id;
		this.roomName = roomName;
		this.capacity = capacity;
		this.count = count;
	}
	
	@Override
	public void run() {
		for (int i=0; i < count; i++) {
			try {
		   		roomService.updateRoomWithOptimisticLock(id, roomName, capacity);
		   		success++;
			}
			catch (OptimisticLockingFailureException e) {
				failure++;
			}
		}
		
		System.err.println("roomName: " + roomName + ", success: " + success + ", failure: " + failure);
	}

}
