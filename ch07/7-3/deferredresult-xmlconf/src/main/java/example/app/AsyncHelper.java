package example.app;

import java.io.File;
import java.io.IOException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AsyncHelper {

	@Async("taskExecutor")
	public void asyncUploading(boolean psudoError, MultipartFile file, 
			DeferredResult<String> deferredResult) throws IOException {

		Console.println("start asyncUploading");

		if (psudoError) {
			deferredResult.setErrorResult(new IllegalStateException("Psudo error."));
			Console.println("error asyncUploading");
			return;
		}

		File tempFile = File.createTempFile("uploaded-", ".jpg");
		file.transferTo(tempFile);

		Console.println("end asyncUploading");
		deferredResult.setResult("redirect:/upload?complete"); 
	}

}
