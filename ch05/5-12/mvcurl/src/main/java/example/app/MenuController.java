package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return "welcome/menu";
	}
}
