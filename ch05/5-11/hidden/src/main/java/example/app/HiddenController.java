package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HiddenController {

	int acceptNo = 1;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		HiddenForm form = new HiddenForm();
		form.setAcceptNo(acceptNo++);
		model.addAttribute(form);
		return "form";
	}

	@RequestMapping(path="/", method=RequestMethod.POST)
	public String login(@Validated HiddenForm form, BindingResult result) {
		System.out.println("acceptNo: " + form.getAcceptNo());
		form.setAcceptNo(acceptNo++);
		return "form";
	}

}
