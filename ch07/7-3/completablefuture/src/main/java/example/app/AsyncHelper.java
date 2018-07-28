package example.app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AsyncHelper {

	@Async("taskExecutor")
	public CompletableFuture<String> asyncUploading(boolean psudoError, MultipartFile file) throws IOException {

		Console.println("start asyncUploading");

		if (psudoError) {
			throw new IllegalStateException("Psudo error.");
		}

		File tempFile = File.createTempFile("uploaded-", ".jpg");
		file.transferTo(tempFile);

		Console.println("end asyncUploading");
		return CompletableFuture.completedFuture("redirect:/upload?complete"); 
	}

}
