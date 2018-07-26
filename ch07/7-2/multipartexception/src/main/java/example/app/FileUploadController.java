package example.app;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute(new FileUploadForm());
		return "file/upload";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String upload(@Validated FileUploadForm form, BindingResult result) throws IOException {
		
		if (result.hasErrors()) return "file/upload";
		
		MultipartFile file = form.getFile();
		String contentType = file.getContentType();
		String parameterName = file.getName();
		String originalFilename = file.getOriginalFilename();
		long fileSize = file.getSize();
		
		System.out.println("contentType:" + contentType);
		System.out.println("parameterName:" + parameterName);
		System.out.println("originalFilename:" + originalFilename);
		System.out.println("fileSize:" + fileSize);

		File tempFile = File.createTempFile("uploaded-", ".jpg");
		file.transferTo(tempFile);
		
		return "redirect:/file/upload?complete";
	}

	@RequestMapping(params = "complete", method = RequestMethod.GET)
	public String complete() {
		return "file/complete";
	}
	
}
