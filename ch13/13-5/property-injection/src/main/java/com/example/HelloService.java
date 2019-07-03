package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
	@Value("${target.host}")
	String host;
	@Value("${target.port}")
	int port;
	
	public String hello() {
		String target = "http://" + host + ":" + port;
		return target;
	}
}
