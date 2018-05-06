package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(path = "create", params = "cancel")
	public String cancel() {
		return "menu";
	}
}
