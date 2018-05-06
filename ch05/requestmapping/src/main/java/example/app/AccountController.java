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
@RequestMapping("accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping({"me/email", "my/email"})
	public String showEmail(Model model) {
		model.addAttribute("email", "sasaki-seiji@msj.biglobe.ne.jp");
		return "email";
	}
	
	@RequestMapping(path = "{accountId}", method = RequestMethod.GET)
	public String showAccount(@PathVariable String accountId, Model model) {
		Account account = accountService.getAccount(accountId);
		model.addAttribute(account);
		return "account";
	}
	
	@RequestMapping(path = "create", params = "form")
	public String form(Model model) {
		model.addAttribute(new Account());
		return "account/form";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "cancel")
	public String cancel() {
		return "menu";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "confirm")
	public String confirm(@Validated Account form, BindingResult result) {
		if (result.hasErrors()) {
			return "account/form";
		}
		return "account/confirm";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "redo")
	public String redo(Account form) {
		return "account/form";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "create")
	public String create(@Validated Account form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		boolean success = accountService.createAccount(form);
		if (!success) return "account/form";
		
		return "redirect:/accounts/create?complete";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.GET, params = "complete")
	public String complete() {
		return "account/complete";
	}
}
