package example.app;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/async")
public class AsyncController {

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String form() {
		return "async/form";
	}

	@RequestMapping(params = "waitSec", method = RequestMethod.GET)
	public Callable<String> get(@RequestParam long waitSec) {

		Console.println("start async");

		Callable<String> callable = () -> {
			Console.println("start callable");
			if (waitSec == 999) {
				throw new IllegalStateException("Psudo error.");
			}
			TimeUnit.SECONDS.sleep(waitSec);
			Console.println("end callable");
			return "redirect:/async?complete"; 
		};

		Console.println("end async");
		return callable;
	}

	@RequestMapping(params = "complete", method = RequestMethod.GET)
	public String complete() {
		return "async/complete";
	}
	
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "aync/error";
    }
}
