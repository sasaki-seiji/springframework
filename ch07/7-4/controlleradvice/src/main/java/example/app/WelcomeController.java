package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(path = "/", method=RequestMethod.GET)
	public String menu() {
		return "menu";
	}
	
	@RequestMapping(path = "/error", method=RequestMethod.GET)
	public String error() {
		throw new RuntimeException("/error");
	}
	
	
}
