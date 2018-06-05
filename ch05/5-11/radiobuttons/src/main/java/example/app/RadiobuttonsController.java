package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RadiobuttonsController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new RadiobuttonsForm());
		return "form";
	}

	@RequestMapping(path="/", method=RequestMethod.POST)
	public String submit(@Validated RadiobuttonsForm form, BindingResult result) {
		System.out.println("gender: " + form.getGender());
		return "form";
	}

}
