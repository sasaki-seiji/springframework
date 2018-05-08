package example.app;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("formclass")
public class FormClassController {

	@RequestMapping(path = "form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new AccountCreateForm());
		return "formclass/form";
	}

	@RequestMapping(path = "create")
	public String create(@Validated AccountCreateForm form, BindingResult result, Model model) {
		if (result.hasErrors()) return "formclass/form";
		
		Date date = form.getDateOfBirth();
		String dateString = date.toString();
		System.out.println("dateOfBirth: " + dateString);
		
		model.addAttribute("result",  dateString);
		return "formclass/result";
	}

}
