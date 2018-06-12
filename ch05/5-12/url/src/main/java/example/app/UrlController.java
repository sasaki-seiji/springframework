package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UrlController {

	int count = 0;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("userId", "sasaki");
		return "form";
	}

	@RequestMapping(path="/users/{userId}", method=RequestMethod.GET)
	public String register(@PathVariable String userId, Model model) {
		System.out.println("userId: " + userId);
		model.addAttribute("userId", "sasaki" + (++count));
		return "form";
	}

}
