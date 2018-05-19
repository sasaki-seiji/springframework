package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.app.AccountCreateForm.FreeAccount;
import example.app.AccountCreateForm.PayAccount;

@Controller
@RequestMapping("/")
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {

		AccountCreateForm form = new AccountCreateForm();
		model.addAttribute(form);
		return "AccountCreateForm";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = {"confirm", "type=1"})
	public String confirmForFreeAccount(
			@Validated(FreeAccount.class) AccountCreateForm form,
			BindingResult result, Model model) {
		return "FreeAccountResult";
	}

	@RequestMapping(method = RequestMethod.POST, params = {"confirm", "type=2"})
	public String confirmForPayAccount(
			@Validated(PayAccount.class) AccountCreateForm form,
			BindingResult result, Model model) {
		return "PayAccountResult";
	}

}
