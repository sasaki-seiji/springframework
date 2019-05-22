package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("checked")
public class CheckedController {

	@RequestMapping(method=RequestMethod.GET)
	public String checkedOutput(Model model, @RequestParam Boolean understand) {
		Info info = new Info();
		info.setUnderstand(understand);
		model.addAttribute(info);
		return "checked/output";
	}

}
