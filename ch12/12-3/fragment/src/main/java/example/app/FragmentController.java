package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("fragment")
public class FragmentController {

	// see 5.4.4
	@RequestMapping(method=RequestMethod.GET, params="include")
	public String include(Model model) {
		return "fragment/include";
	}

	// see 5.4.4
	@RequestMapping(method=RequestMethod.GET, params="replace")
	public String replace(Model model) {
		return "fragment/replace";
	}

}
