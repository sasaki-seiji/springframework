package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResponseStatusController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form() {
		return "form";
	}

	@RequestMapping(path="/resourcenotfound", method=RequestMethod.GET)
	public String exception() throws Exception {
		throw new ResourceNotFoundException("resource not found");
	}

}
