package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(path = "search", params = "form", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute(new AccountSearchForm());
		return "account/searchForm";
	}
	
	@RequestMapping(path = "search", params = "execute", method = RequestMethod.GET)
	public String search(
			@Validated AccountSearchForm form, 
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "account/searchForm";
		}
		
		String accountName = form.getName();
		AccountCreateForm account = accountService.getAccount(accountName);
		if(account == null) {
			model.addAttribute("name", accountName);
			return "account/searchNotFound";
		}
		
		model.addAttribute(account);
		return "account/searchResult";
	}

}
