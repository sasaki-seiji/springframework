package example.app;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("stringtrimmer")
public class StringTrimmerController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {

		ValidationForm form = new ValidationForm();
		model.addAttribute(form);
		model.addAttribute("title", "String Trimmer");
		return "validationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String validate(
			@Validated ValidationForm form, BindingResult result, Model model) {

		model.addAttribute("title", "String Trimmer");
		if(result.hasErrors()) {
			return "validationForm";
		}
		return "validationResult";
	}

}
