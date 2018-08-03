package example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(path = "/")
	public String home(CommonRequestData commonRequestData, Model model) {

		String userAgent = commonRequestData.getUserAgent();
		String sessionId = commonRequestData.getSessionId();

		System.out.println("userAgent: " + userAgent);
		System.out.println("sessionId: " + sessionId);
		
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("sessionId", sessionId);
		return "home";
	}
	
}
