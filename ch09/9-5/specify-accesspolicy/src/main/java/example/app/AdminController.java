package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {

	@RequestMapping(path = "menu", method = RequestMethod.GET)
	public String adminMenu() {
		return "adminMenu";
	}

	@RequestMapping(path = "accounts/menu", method = RequestMethod.GET)
	public String accountsMenu() {
		return "accountsMenu";
	}

	@RequestMapping(path = "configurations/menu", method = RequestMethod.GET)
	public String configulationsMenu() {
		return "configurationsMenu";
	}

}
