package com.example.domain.repository;


import com.example.domain.model.Counter;

public interface CounterService {
	// 10.6.3: optimistic lock
	void increment(Integer id, Integer delta);

	// 10.6.1: crud
	Counter getCounter(Integer id);
}
