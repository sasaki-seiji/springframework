package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

	@Autowired
	TargetProperties	targetProperties;
	
	public String hello() {
		String target = "http://" + targetProperties.getHost() 
						+ ":" + targetProperties.getPort();
		return target;
	}
}
