package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlEscapeController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("defaultHtmlEscape", "<h3>defaultHtmlEscape</h3>");
		model.addAttribute("defaultHtmlEscapeTrue", "<h3>defaultHtmlEscapeTrue</h3>");
		return "form";
	}


}
