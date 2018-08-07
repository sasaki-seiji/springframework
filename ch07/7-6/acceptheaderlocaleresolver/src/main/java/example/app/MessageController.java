package example.app;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form(Locale local) {
		System.out.println("Local: " + local);
		return "form";
	}

}
