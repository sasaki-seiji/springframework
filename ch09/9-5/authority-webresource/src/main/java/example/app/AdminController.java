package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(path = "admin/menu", method = RequestMethod.GET)
	public String adminMenu() {
		return "adminMenu";
	}

	@RequestMapping(path = "admin/accounts/menu", method = RequestMethod.GET)
	public String accountsMenu() {
		return "accountsMenu";
	}
}
