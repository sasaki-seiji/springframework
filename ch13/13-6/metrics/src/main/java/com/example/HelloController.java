package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping("/hello")
	public String hello(Model model) {

		// 2019.07.06 add
		helloService.hello();
		
		model.addAttribute("hello", "Hello Actuator Metrics!");
		return "hello";
	}
}
