package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ELFunctionController {

	@RequestMapping("/")
	public String expressionLanguage(Model model) {
		model.addAttribute("message", "<script>alert('surprize')</script>");
		return "ELFunction";
	}
}
