package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

		@RequestMapping("/")
		public String hello(Model model) {
			model.addAttribute("welcome", "welcome to static file sample");
			return "index";
		}
}
