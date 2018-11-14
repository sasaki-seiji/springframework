package example.app;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String home() {
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		String userUuid = null;
		if (authentication.getPrincipal() instanceof AccountUserDetails) {
			AccountUserDetails userDetails =
					AccountUserDetails.class.cast(authentication.getPrincipal());
			userUuid = userDetails.getAccount().getUserUuid();
			System.out.println("userUuid: " + userUuid);
		}
		return "index"; 
	}
}
