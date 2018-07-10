package example.postforlocation;

import java.net.URI;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;
	
	public void call() {
		BookResource resource = new BookResource();
		resource.setName("Spring 徹底入門");
		resource.setPublishedDate(LocalDate.of(2016, 4, 1));
		
		URI createdResourceUri = restOperations.postForLocation(
			"http://localhost:8080/restapi/books", resource);

		System.out.println("uri: " + createdResourceUri);
	}
	

}
