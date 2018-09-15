package example.app;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorPageController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String form() {
		return "form";
	}

	@RequestMapping(path="/exception", method=RequestMethod.GET)
	public String exception() throws Exception {
		throw new Exception("throw Exception");
	}

	@RequestMapping(path="/ioexception", method=RequestMethod.GET)
	public String ioexception() throws Exception {
		throw new IOException("throw Exception");
	}
	
	@RequestMapping(path="/internalservererror", method=RequestMethod.GET)
	public String error() throws Error
	{
		System.out.println("/internalservererror");
		throw new InternalServerError("throw InternalServerError");
	}
}
