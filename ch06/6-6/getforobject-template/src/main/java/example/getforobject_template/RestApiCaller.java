package example.getforobject_template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;
	
	public void call() {
		String bookId = "00000000-0000-0000-0000-000000000000";
		
		BookResource resource = restOperations.getForObject(
			"http://localhost:8080/restapi/books/{bookId}",
			BookResource.class, bookId);
		System.out.println("bookId: " + resource.getBookId());
		System.out.println("name: " + resource.getName());
		System.out.println("publishedDate: " + resource.getPublishedDate());
	}
	

}
