package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("hello", "Hello Thymeleaf!");
		return "hello";
	}
}
