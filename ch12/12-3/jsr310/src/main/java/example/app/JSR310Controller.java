package example.app;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("jsr310")
public class JSR310Controller {

	@RequestMapping(method=RequestMethod.GET)
	public String output(Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("date", now);
		return "jsr310/output";
	}

}
