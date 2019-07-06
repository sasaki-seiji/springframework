package com.example;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class RandomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		if (new Random().nextBoolean()) {
			return Health.up().build();
		}
		else {
			return Health.down().withDetail("error_code", 100).build();
		}
	}

}
