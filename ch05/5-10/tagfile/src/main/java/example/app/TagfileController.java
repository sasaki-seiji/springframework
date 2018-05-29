package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TagfileController {

	@RequestMapping("/")
	public String customTaglib() {
		return "tagfile";
	}

}
