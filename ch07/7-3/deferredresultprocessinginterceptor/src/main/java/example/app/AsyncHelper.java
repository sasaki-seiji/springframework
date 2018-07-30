package example.app;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

@Component
public class AsyncHelper {

	@Async
	public void asyncProcessing(long waitSec, DeferredResult<String> deferredResult) {

		try {
			Console.println("start asyncProcessing");

			if (waitSec == 999) {
				throw new IllegalStateException("Psudo error.");
			}
			
			TimeUnit.SECONDS.sleep(waitSec);

			deferredResult.setResult("redirect:/async?complete"); 
			Console.println("end asyncProcessing");
		}
		catch (Exception e) {
			deferredResult.setErrorResult(e);
			Console.println("error asyncProcessing");
		}
	}
}
