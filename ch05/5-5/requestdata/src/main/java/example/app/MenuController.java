package example.app;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

	@RequestMapping("/")
	public String menu(HttpServletResponse response) {
		response.addCookie(new Cookie("example.springbook.cartId", "foo"));
		return "menu"; 
	}
	
	@RequestMapping(path = "accounts/{accountId}", method = RequestMethod.GET) 
	public String pathVariable(@PathVariable String accountId) {
		System.out.println("accountId: " + accountId);
		return "menu";
	}

	@RequestMapping(path = "detail", method = RequestMethod.GET) 
	public String requestParam(@RequestParam String format) {
		System.out.println("format: " + format);
		return "menu";
	}

	@RequestMapping(path = "accounts", method = RequestMethod.GET) 
	public String attribute(
			@CookieValue("example.springbook.cartId") String cartId,
			@RequestHeader(name = "X-Track-Id", required = false) String trackingId,
			@RequestParam(defaultValue = "1") Integer page) {
		System.out.println("cartId: " + cartId + ", trackingId: " + trackingId
				+ ", page: " + page);
		return "menu";
	}
}
