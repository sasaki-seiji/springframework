package com.example.pessimistic_increment;

import org.springframework.dao.PessimisticLockingFailureException;

import com.example.domain.repository.CounterService;

public class MultiIncrementer implements Runnable {

	private CounterService counterService;
	private int[] ids;
	private int[] deltas;
	private int	count;
	private int success;
	private int failure;
	
	public int getSuccess() { return this.success; }
	public int getFailure() { return this.failure; }
	
	MultiIncrementer(CounterService counterService, int[] ids, int[] deltas, int count) {
		this.counterService = counterService;
		this.ids = ids;
		this.deltas = deltas;
		this.count = count;
		this.success = this.failure = 0;
	}
	
	@Override
	public void run() {
		while (this.success < this.count) {
			try {
		   		counterService.increment(ids, deltas);
		   		this.success++;
			}
			catch (PessimisticLockingFailureException e) {
				this.failure++;
			}
		}
		
	}

}
