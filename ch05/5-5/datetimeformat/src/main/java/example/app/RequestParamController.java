package example.app;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("requestparam")
public class RequestParamController {

	@RequestMapping(path = "search", method = RequestMethod.GET)
	public String search(@DateTimeFormat(pattern = "yyyyMMdd") @RequestParam Date targetDate, 
			Model model) {

		String dateString = targetDate.toString();
		System.out.println("targetDate: " + dateString);
		
		model.addAttribute("result",  dateString);
		return "requestparam/result";
	}

}
