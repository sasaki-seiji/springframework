package example.app;

import java.io.File;
import java.io.IOException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AsyncHelper {

	@Async
	public void asyncUploading(boolean psudoError, MultipartFile file, 
			DeferredResult<String> deferredResult) throws IOException {

		try {
			Console.println("start asyncUploading");

			if (psudoError) {
				throw new IllegalStateException("Psudo error.");
			}
			
			File tempFile = File.createTempFile("uploaded-", ".jpg");
			file.transferTo(tempFile);

			deferredResult.setResult("redirect:/upload?complete"); 
			Console.println("end asyncUploading");
		}
		catch (Exception e) {
			deferredResult.setErrorResult(e);
			Console.println("error asyncUploading");
		}
	}
}
