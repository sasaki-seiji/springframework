package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String viewLoginForm() {
		return "loginForm";
	}

	@RequestMapping(path = "/menu", method = RequestMethod.GET)
	public String viewMenu() {
		return "menu";
	}

}
