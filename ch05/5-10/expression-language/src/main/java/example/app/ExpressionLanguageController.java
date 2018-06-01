package example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExpressionLanguageController {

	private Javabeans javabeans = new Javabeans("java beans text");
	private List<Javabeans> javabeansList = new ArrayList<Javabeans>();
	private Map<String, String> map = new HashMap<String,String>();
	
	@RequestMapping("/")
	public String expressionLanguage(Model model) {
		model.addAttribute("message", "this is expression language message string");

		model.addAttribute("javabeans", javabeans);

		javabeansList.add(new Javabeans("java beans list[0] text"));
		model.addAttribute("javabeansList", javabeansList);
		
		map.put("sport", "baseball");
		map.put("guidance.termsOfUse", "使い方のガイド");
		model.addAttribute("map", map);
		return "expressionLanguage";
	}

}
