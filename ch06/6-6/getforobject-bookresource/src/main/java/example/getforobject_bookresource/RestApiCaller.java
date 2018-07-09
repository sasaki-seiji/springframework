package example.getforobject_bookresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;
	
	public void call() {
		BookResource resource = restOperations.getForObject(
			"http://localhost:8080/restapi/books/00000000-0000-0000-0000-000000000000",
			BookResource.class);
		System.out.println("bookId: " + resource.getBookId());
		System.out.println("name: " + resource.getName());
		System.out.println("publishedDate: " + resource.getPublishedDate());
	}
	

}
