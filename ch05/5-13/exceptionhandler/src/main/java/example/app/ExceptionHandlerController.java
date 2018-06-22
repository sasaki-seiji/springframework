package example.app;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionHandlerController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form() {
		return "form";
	}

	@RequestMapping(path="/exception", method=RequestMethod.GET)
	public String exception() throws Exception {
		throw new Exception("thow Exception");
	}

	@RequestMapping(path="/ioexception", method=RequestMethod.GET)
	public String ioexception() throws Exception {
		throw new IOException("thow Exception");
	}

}
