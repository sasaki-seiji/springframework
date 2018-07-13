package example.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;

	public void call() {
		String url = "http://localhost:8080/restapi/books/00000000-0000-0000-0000-000000000000";

		restOperations.delete(url);

		try {
			BookResource resource = restOperations.getForObject(url, BookResource.class);
			System.out.println("bookId: " + resource.getBookId());
			System.out.println("name: " + resource.getName());
			System.out.println("publishedDate: " + resource.getPublishedDate());
		} catch (HttpClientErrorException ex) {
			System.out.println(ex);
		}
	}

}
