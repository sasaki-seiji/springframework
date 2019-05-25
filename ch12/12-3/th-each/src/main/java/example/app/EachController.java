package example.app;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("each")
public class EachController {

	@RequestMapping(method=RequestMethod.GET)
	public String checkedOutput(Model model) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("lemmon", 100, 10));
		products.add(new Product("apple", 500, 20));
		products.add(new Product("potato", 200, 0));
		products.add(new Product("orange", 777, 30));
		products.add(new Product("berry", 398, 0));
		model.addAttribute("products", products);
		return "each/output";
	}

}
