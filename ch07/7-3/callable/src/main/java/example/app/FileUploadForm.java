package example.app;

import java.io.Serializable;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	private MultipartFile file;
	public MultipartFile getFile() { return this.file; }
	public void setFile(MultipartFile file) { this.file = file; }
}
