package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("inline")
public class InlineController {

	@RequestMapping(method=RequestMethod.GET)
	public String checkedOutput(Model model) {
		User user = new User();
		user.setName("sasaki");
		model.addAttribute(user);
		return "inline/output";
	}

}
