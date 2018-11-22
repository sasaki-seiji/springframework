package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	AccountService accountService;

	// 2018.11.18 add
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<String> usernames = accountService.getAllUsernames();
		model.addAttribute("usernames", usernames);
		return "userlist";
	}
	
	// 2018.11.18 add: see 5.4.2
	@RequestMapping(value="{username}", method = RequestMethod.GET)
	public String profile(@PathVariable String username, Model model) {
		Account account = accountService.findOne(username); 
		model.addAttribute(account);
		return "profile";
	}
}
