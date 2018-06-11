package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BindController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new AccountCreateForm());
		return "form";
	}

	@RequestMapping(path="/", method=RequestMethod.POST)
	public String register(@Validated AccountCreateForm form, BindingResult result, Model model) {
		System.out.println("username: " + form.getUsername());
		System.out.println("dateOfBirth: " + form.getDateOfBirth());
		return "form";
	}

}
