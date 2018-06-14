package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EscapeBodyController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("messageHtml", "<h3>htmlEscape</h3>");
		model.addAttribute("messageJS", "alert('hello')");
		model.addAttribute("messageHtmlJS", "<h3>alert('hello')</h3>");
		return "form";
	}

}
