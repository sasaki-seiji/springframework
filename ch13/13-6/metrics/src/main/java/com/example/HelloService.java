package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class HelloService {

	Counter helloCounter;
	
	@Autowired
	public HelloService(MeterRegistry meterRegistry) {
		helloCounter = meterRegistry.counter("hello.invoked");
	}
	
	public void hello() {
		this.helloCounter.increment();
	}
}
