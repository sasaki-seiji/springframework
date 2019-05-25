package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("if-switch")
public class IfSwitchController {

	@RequestMapping(method=RequestMethod.GET)
	public String checkedOutput(Model model, 
			@RequestParam String remark, @RequestParam String size) {
		Room room = new Room();
		room.setRemark(remark);
		room.setSize(size);
		model.addAttribute(room);
		return "if-switch/output";
	}

}
