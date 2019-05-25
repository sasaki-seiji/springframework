package example.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("attr")
public class AttrController {

	@RequestMapping(method=RequestMethod.GET)
	public String checkedOutput(Model model) {
		Product product = new Product();
		product.setId("P00001");
		model.addAttribute(product);
		return "attr/output";
	}

}
