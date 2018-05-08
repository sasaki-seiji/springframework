package example.app;

import java.util.Date;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customformatter")
public class CustomFormatterController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyyMMdd"));
	}
	
	@RequestMapping(path = "form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute(new SearchForm());
		return "form";
	}

	@RequestMapping(path = "search")
	public String search(@Validated SearchForm form, BindingResult result, Model model) {
		if (result.hasErrors()) return "form";
		
		Date date = form.getDate();
		String dateString = date.toString();
		System.out.println("date: " + dateString);
		
		model.addAttribute("result",  dateString);
		return "result";
	}
}
