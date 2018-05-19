package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class AccountCreateController {

	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {

		AccountCreateForm form = new AccountCreateForm();
		model.addAttribute(form);
		return "AccountCreateForm";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "clear")
	public String clear(Model model) {

		return form(model);
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "confirm")
	public String confirm(
			@Validated AccountCreateForm form, BindingResult result, Model model) {

		if(result.hasErrors()) {
			return "AccountCreateForm";
		}
		return "AccountCreateResult";
	}
	
}
