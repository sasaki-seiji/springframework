package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accounts")
public class AccountController {

	@RequestMapping({"me/email", "my/email"})
	public String showEmail(Model model) {
		model.addAttribute("email", "sasaki-seiji@msj.biglobe.ne.jp");
		return "email";
	}
}
