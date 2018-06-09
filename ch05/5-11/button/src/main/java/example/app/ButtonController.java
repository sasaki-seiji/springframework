package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ButtonController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new ButtonForm());
		return "form";
	}

	@RequestMapping(path="/", params="confirm", method=RequestMethod.POST)
	public String confirm(@Validated ButtonForm form, BindingResult result) {
		System.out.println("confirm");
		return "form";
	}

	@RequestMapping(path="/", params="cancel", method=RequestMethod.POST)
	public String cancel(@Validated ButtonForm form, BindingResult result) {
		System.out.println("cancel");
		return "form";
	}

}
