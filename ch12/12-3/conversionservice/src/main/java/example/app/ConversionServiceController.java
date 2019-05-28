package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("conversionservice")
public class ConversionServiceController {

	@RequestMapping(method=RequestMethod.GET)
	public String output(Model model) {
		return "conversionservice/output";
	}

}
