package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AccountController {

	@Autowired
	AccountCreateFormValidator accountCreateFormValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(accountCreateFormValidator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {

		AccountCreateForm form = new AccountCreateForm();
		model.addAttribute(form);
		return "AccountCreateForm";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = {"confirm"})
	public String confirmForFreeAccount(
			@Validated AccountCreateForm form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "AccountCreateForm";
		}
		
		if (form.getType().equals("1")) {
			return "FreeAccountResult";
		}
		else {
			return "PayAccountResult";
		}
	}

}
