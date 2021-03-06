package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String home() {
		return "index"; 
	}

	@RequestMapping(path = "/menu", method = RequestMethod.GET)
	public String viewMenu() {
		return "menu";
	}

}
