package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/resources")
public class ResoucesController {

	@RequestMapping(method=RequestMethod.GET)
	public String getResource() {
		return "resources";
	}

	@RequestMapping(path = "error", method=RequestMethod.GET)
	public String error() {
		throw new RuntimeException("/resources/error");
	}

}
