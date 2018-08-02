package example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/")
	public String hello() {
		logger.info("dispatched hello()");
		return "/hello";
	}

}
