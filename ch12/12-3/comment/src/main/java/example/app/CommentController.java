package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("comment")
public class CommentController {

	@RequestMapping(method=RequestMethod.GET)
	public String checkedOutput(Model model) {
		return "comment/output";
	}

}
