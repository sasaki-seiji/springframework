package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomTaglibController {

	@RequestMapping("/")
	public String customTaglib() {
		return "customTaglib";
	}

}
