package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String home() {
		return "redirect:/menu";
	}
	
	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}
}
