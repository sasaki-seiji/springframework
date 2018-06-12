package example.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransformController {

	@Autowired
	List<Date> targetDateList;
	
	@ModelAttribute("targetDateList")
	public List<Date> dateList()
	{
		return targetDateList;
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new TransformForm());
		return "form";
	}

	@RequestMapping(path="/", method=RequestMethod.POST)
	public String register(@Validated TransformForm form, BindingResult result, Model model) {
		System.out.println("departure: " + form.getDepartureDate());
		return "form";
	}

}
