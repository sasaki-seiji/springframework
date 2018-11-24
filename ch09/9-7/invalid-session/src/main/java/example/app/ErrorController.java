package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("error")
public class ErrorController {

	@RequestMapping(path = "invalidSession", method = RequestMethod.GET)
	public String invalidSession() {
		return "invalidSessionError";
	}
}
