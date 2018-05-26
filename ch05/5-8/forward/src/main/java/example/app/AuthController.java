package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("auth")
public class AuthController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(path="login", params="form", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new LoginForm());
		return "auth/loginForm";
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public String login(@Validated LoginForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "auth/loginForm";
		}
		return "forward:/auth/authenticate";
	}

	@RequestMapping(path="authenticate")
	public String authenticate(@Validated LoginForm form, BindingResult result) {
		
		boolean authenticated = accountService.authenticate(form);
		if (!authenticated) {
			return "auth/loginForm";
		}
		return "auth/welcome";
	}
}
