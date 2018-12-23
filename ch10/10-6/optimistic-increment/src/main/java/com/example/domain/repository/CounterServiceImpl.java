package com.example.domain.repository;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Counter;

@Service("counterService")
public class CounterServiceImpl implements CounterService {

	@Autowired
	CounterRepository	counterRepository;

	// 10.6.3: optimistic lock

	@Transactional
	@Override
	public void increment(Integer id, Integer delta) {
		Counter counter = getCounter(id);
		counter.setCount(counter.getCount() + delta);
	}

	// 10.6.1: crud
	
	@Transactional(readOnly = true)
	@Override
	public Counter getCounter(Integer id) {
		// 2018.12.22 change
		// see https://stackoverflow.com/questions/49316751/spring-data-jpa-findone-change-to-optional-how-to-use-this
		//Room room = roomRepository.findOne(id);
		Optional<Counter> counter = counterRepository.findById(id);
		return counter.orElseThrow(() -> new RuntimeException("not found counter with specified id"));
	}

}
