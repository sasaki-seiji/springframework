package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@ModelAttribute
	public Account setUpAccount(@PathVariable String accountId) {
		Account account = accountService.findOne(accountId);
		if (account == null) {
			return new Account(accountId, "不明のアカウント");
		}
		return account;
	}
	
	@RequestMapping("{accountId}")
	public String detail() {
		return "account/detail";
	}

}
