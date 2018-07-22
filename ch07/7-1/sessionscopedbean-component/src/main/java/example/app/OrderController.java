package example.app;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	Cart cart;
	
	@RequestMapping(params = "order", method = RequestMethod.POST)
	public String order() {
		return "redirect:/order?confirm";
	}

	@RequestMapping(params = "confirm", method = RequestMethod.GET)
	public String confirm(Model model) {
		Collection<ItemQuantity> contents = cart.getContents();
		model.addAttribute("contents", contents);
		return "order/confirm";
	}
	
	@RequestMapping(params = "complete", method = RequestMethod.GET)
	public String complete(Model model) {
		int totalQuantity = cart.getTotalQuantity();
		int totalPrise = cart.getTotalPrise();
		cart.clearAll();
		
		model.addAttribute("totalQuantity", totalQuantity);
		model.addAttribute("totalPrise", totalPrise);
		return "order/complete";
	}

	@RequestMapping(params = "editCart", method = RequestMethod.GET)
	public String cancel() {
		return "redirect:/cart";
	}

}
