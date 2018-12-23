package com.example.optimistic_increment;

import org.springframework.dao.OptimisticLockingFailureException;

import com.example.domain.repository.CounterService;

public class Incrementer implements Runnable {

	private CounterService counterService;
	private Integer id;
	private Integer delta;
	private int	count;
	private int success;
	private int failure;
	
	public int getSuccess() { return this.success; }
	public int getFailure() { return this.failure; }
	
	Incrementer(CounterService counterService, Integer id, Integer delta, int count) {
		this.counterService = counterService;
		this.id = id;
		this.delta = delta;
		this.count = count;
		this.success = this.failure = 0;
	}
	
	@Override
	public void run() {
		while (this.success < this.count) {
			try {
		   		counterService.increment(id, delta);
		   		this.success++;
			}
			catch (OptimisticLockingFailureException e) {
				this.failure++;
			}
		}
		
	}

}
