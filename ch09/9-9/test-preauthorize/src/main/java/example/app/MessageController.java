package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@RequestMapping(path = "list", method = RequestMethod.GET)
	public String messageList(Model model) {
		List<Message> messageList = messageService.getAllMessages();
		model.addAttribute("messageList", messageList);
		return "messageList";
	}

}
