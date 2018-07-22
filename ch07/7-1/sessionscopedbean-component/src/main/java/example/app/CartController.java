package example.app;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	Cart cart;
	
	@RequestMapping(method = RequestMethod.GET)
	public String content(Model model) {
		Collection<ItemQuantity> contents = cart.getContents();
		model.addAttribute("contents", contents);
		return "cart/contents";
	}
	
	@RequestMapping(path = "{id}", params = "increment", method = RequestMethod.POST)
	public String increment(@PathVariable("id") String id) {
		System.out.printf("post /cart/%s?increment=\n", id);
		Item item = itemService.get(id);
		System.out.println("item=" + item);
		cart.incrementItem(item);
		
		return "redirect:/cart";
	}

	@RequestMapping(path = "{id}", params = "decrement", method = RequestMethod.POST)
	public String decrement(@PathVariable("id") String id) {
		System.out.printf("post /cart/%s?decrement=\n", id);
		Item item = itemService.get(id);
		System.out.println("item=" + item);
		cart.decrementItem(item);
		
		return "redirect:/cart";
	}

	@RequestMapping(path = "{id}", params = "clear", method = RequestMethod.POST)
	public String clear(@PathVariable("id") String id) {
		System.out.printf("post /cart/%s?clear=\n", id);
		cart.clearItem(id);
		
		return "redirect:/cart";
	}

}
