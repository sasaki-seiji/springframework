package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
		model.addAttribute("message",  new Message());
		return "messageList";
	}

	@RequestMapping(path = "add", method = RequestMethod.POST) 
	public String addMessage(@Validated Message message, BindingResult result) {
		messageService.addMessage(message.getMessage());
		return "redirect:/message/list";
	}
}
