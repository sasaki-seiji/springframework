package example.app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute(new FileUploadForm());
		return "upload/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Callable<String> upload(@Validated FileUploadForm form, BindingResult result) throws IOException {
		
		Console.println("start upload");

		MultipartFile file = form.getFile();
		String contentType = file.getContentType();
		String parameterName = file.getName();
		String originalFilename = file.getOriginalFilename();
		long fileSize = file.getSize();
		
		System.out.println("contentType:" + contentType);
		System.out.println("parameterName:" + parameterName);
		System.out.println("originalFilename:" + originalFilename);
		System.out.println("fileSize:" + fileSize);
		System.out.println("psudoError: " + form.getPsudoError());
		
		File tempFile = File.createTempFile("uploaded-", ".jpg");
		Callable<String> callable = () -> {
			Console.println("start callable");
			if (form.getPsudoError()) {
				throw new IllegalStateException("Psudo error.");
			}
			file.transferTo(tempFile);
			Console.println("end callable");
			return "redirect:/upload?complete"; 
		};

		Console.println("end upload");
		return callable;
	}

	@RequestMapping(params = "complete", method = RequestMethod.GET)
	public String complete() {
		return "upload/complete";
	}
	
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }
	
}
