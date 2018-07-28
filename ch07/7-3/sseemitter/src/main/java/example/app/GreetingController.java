package example.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RequestMapping("/")
public class GreetingController {

	@Autowired
	GreetingMessageSender greetingMessageSender;
	
	@RequestMapping(path = "greeting", method = RequestMethod.GET)
	public SseEmitter greeting() throws IOException, InterruptedException {
		SseEmitter emitter = new SseEmitter();
		greetingMessageSender.send(emitter);
		return emitter;
	}
}
