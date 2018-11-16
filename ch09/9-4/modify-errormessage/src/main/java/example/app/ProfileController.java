package example.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@RequestMapping(method = RequestMethod.GET)
	public String view(
			@AuthenticationPrincipal AccountUserDetails userDetails,
			Model model) {
		model.addAttribute(userDetails.getAccount());
		return "profile";
	}
}
