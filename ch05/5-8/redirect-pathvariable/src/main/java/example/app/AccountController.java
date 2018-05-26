package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(path = "create", params = "form")
	public String form(Model model) {
		model.addAttribute(new AccountCreateForm());
		return "account/form";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "create")
	public String create(@Validated AccountCreateForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) return "account/form";
		boolean success = accountService.createAccount(form);
		if (!success) return "account/form";
		
		redirectAttributes.addAttribute("accountId", form.getId());
		return "redirect:/accounts/{accountId}?complete";
	}
	
	@RequestMapping(path = "{accountId}", method = RequestMethod.GET, params = "complete")
	public String complete(@PathVariable String accountId, Model model) {
		AccountCreateForm result = accountService.getAccount(accountId);
		model.addAttribute(result);
		return "account/complete";
	}

}
