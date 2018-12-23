package com.example.domain.repository;


import java.util.List;

import com.example.domain.model.Counter;

public interface CounterService {
	// 10.6.3: pessimistic-write lock
	void increment(int[] ids, int[] deltas);

	// 10.6.1: crud
	Counter getCounter(Integer id);
	List<Counter> getAllCounters();
}
