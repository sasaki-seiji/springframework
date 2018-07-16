package example.handle_timeout_javaconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;

	public void call() {

		try {
			String url = "http://localhost:8080/handle-servleterror/books/slow/00000000-0000-0000-0000-000000000000";

			System.out.println("try get " + url);
			BookResource resource = restOperations.getForObject(url, BookResource.class);
			System.out.println("bookId: " + resource.getBookId());
			System.out.println("name: " + resource.getName());
			System.out.println("publishedDate: " + resource.getPublishedDate());
		} catch (ResourceAccessException ex) {
			System.out.println(ex);
		}
	}

}
