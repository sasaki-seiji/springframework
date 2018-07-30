package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	AsyncHelper asyncHelper;
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String form() {
		return "async/form";
	}

	@RequestMapping(params = "waitSec", method = RequestMethod.GET)
	public DeferredResult<String> get(@RequestParam long waitSec) {

		Console.println("start async: waitSec=" + waitSec);

		DeferredResult<String> deferredResult = new DeferredResult<>();
		asyncHelper.asyncProcessing(waitSec, deferredResult);
		
		Console.println("end async");
		return deferredResult;
	}

	@RequestMapping(params = "complete", method = RequestMethod.GET)
	public String complete() {
		return "async/complete";
	}
	
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "async/error";
    }
}
