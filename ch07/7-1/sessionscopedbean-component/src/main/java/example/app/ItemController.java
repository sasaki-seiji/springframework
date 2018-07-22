package example.app;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		Collection<Item> items = itemService.getAllItems();
		model.addAttribute("items", items);
		return "item/list";
	}
}
