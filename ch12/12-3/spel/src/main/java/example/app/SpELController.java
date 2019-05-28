package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("spel")
public class SpELController {

	@RequestMapping(method=RequestMethod.GET)
	public String output(Model model) {
		return "spel/output";
	}

}
