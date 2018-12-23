package com.example.optimistic_lock;

import org.springframework.dao.OptimisticLockingFailureException;

import com.example.domain.repository.RoomWithVersionService;

public class RoomUpdater implements Runnable {

	private RoomWithVersionService roomWithVersionService;
	private Integer id;
	private String roomName;
	private Integer capacity;
	private int	count;
	private int success;
	private int failure;
	
	public int getSuccess() { return this.success; }
	public int getFailure() { return this.failure; }
	
	RoomUpdater(RoomWithVersionService roomWithVersionService, Integer id, String roomName, Integer capacity, int count) {
		this.roomWithVersionService = roomWithVersionService;
		this.id = id;
		this.roomName = roomName;
		this.capacity = capacity;
		this.count = count;
		this.success = this.failure = 0;
	}
	
	@Override
	public void run() {
		for (int i=0; i < count; i++) {
			try {
		   		roomWithVersionService.updateRoomWithOptimisticLock(id, roomName, capacity);
		   		success++;
			}
			catch (OptimisticLockingFailureException e) {
				failure++;
			}
		}
		
	}

}
