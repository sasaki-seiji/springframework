package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScriptletController {

	@RequestMapping("/")
	public String scriptlet() {
		return "scriptlet";
	}

}
