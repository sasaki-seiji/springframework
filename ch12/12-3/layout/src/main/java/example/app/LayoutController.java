package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("layout")
public class LayoutController {

	@RequestMapping(method=RequestMethod.GET)
	public String include(Model model) {
		return "layout/Fragment";
	}

}
