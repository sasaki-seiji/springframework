package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("classappend")
public class ClassappendController {

	// see 5.4.4
	@RequestMapping(method=RequestMethod.GET, params = "lighter")
	public String LighterOutput(Model model) {
		model.addAttribute("cssStyle", "lighter");
		return "classappend/output";
	}

	// see 5.4.4
	@RequestMapping(method=RequestMethod.GET, params = "darker")
	public String DarkerOutput(Model model) {
		model.addAttribute("cssStyle", "darker");
		return "classappend/output";
	}

}
