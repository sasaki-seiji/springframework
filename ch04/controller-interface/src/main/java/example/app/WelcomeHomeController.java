package example.app;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Component("/")
public class WelcomeHomeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("now", new Date());
		return mav;
	}
}