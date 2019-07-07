package com.example;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// 2019.07.07 change: see 9.4.11
	@RequestMapping("/")
	public String welcome(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		String user = userDetails.getUsername();
		model.addAttribute("user", user);
		return "welcome";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("hello", "Hello Actuator security demo!");
		return "hello";
	}
}
