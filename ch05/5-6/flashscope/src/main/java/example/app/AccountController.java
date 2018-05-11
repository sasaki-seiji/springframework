package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(path = "search", params = "form", method = RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute(new SearchForm());
		return "account/searchform";
	}
	
	@RequestMapping(path = "search", params = "search", method = RequestMethod.GET)
	public String showAccount(@Validated SearchForm form, Model model) {
		String accountName = form.getName();
		AccountCreateForm account = accountService.getAccount(accountName);
		model.addAttribute(account);
		return "account/detail";
	}
	
	@RequestMapping(path = "create", params = "form")
	public String form(Model model) {
		model.addAttribute(new AccountCreateForm());
		return "account/form";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "cancel")
	public String cancel() {
		return "menu";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.POST, params = "create")
	public String create(@Validated AccountCreateForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		boolean success = accountService.createAccount(form);
		if (!success) return "account/form";
		
		redirectAttributes.addFlashAttribute(form);
		return "redirect:/accounts/create?complete";
	}
	
	@RequestMapping(path = "create", method = RequestMethod.GET, params = "complete")
	public String complete(AccountCreateForm form, Model model) {
		model.addAttribute(form);
		return "account/complete";
	}
}
