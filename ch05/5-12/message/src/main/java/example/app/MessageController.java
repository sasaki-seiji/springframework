package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form() {
		return "form";
	}

}
