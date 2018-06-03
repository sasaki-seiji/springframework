package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

	@RequestMapping(path="/")
	public String form() {
		return "forward:/login";
	}
	
	@RequestMapping(path="login", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new LoginForm());
		return "form";
	}

	@RequestMapping(path="login", method=RequestMethod.POST)
	public String login(@Validated LoginForm form, BindingResult result) {
		System.out.println("username: " + form.getUsername());
		System.out.println("password: " + form.getPassword());
		return "form";
	}
}
