package example.app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("accounts")
public class AccountController {

	@RequestMapping(path = "search", params = "form", method = RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute(new SearchForm());
		return "account/searchform";
	}
	
	@RequestMapping(path = "search", params = "search", method = RequestMethod.GET)
	public String showAccount(@Validated SearchForm form, Model model) {
		List<String> roles = form.getRoles();
		System.out.println("roles: " + roles);
		return "menu";
	}
	
}
