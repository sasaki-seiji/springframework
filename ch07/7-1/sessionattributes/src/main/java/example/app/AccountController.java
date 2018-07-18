package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/accounts")
@SessionAttributes(types = AccountCreateForm.class)
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@ModelAttribute("accountCreateForm")
	public AccountCreateForm setUpAccountCreateForm() {
		return new AccountCreateForm();
	}
	
	@RequestMapping(path = "create", params = "form")
	public String form() {
		return "account/form";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "create")
	public String create(@Validated AccountCreateForm form, BindingResult result) {
		if (result.hasErrors()) return "account/form";
		boolean success = accountService.createAccount(form);
		if (!success) return "account/form";
		
		return "redirect:/accounts/create?complete";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.GET, params = "complete")
	public String complete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "account/complete";
	}

}
