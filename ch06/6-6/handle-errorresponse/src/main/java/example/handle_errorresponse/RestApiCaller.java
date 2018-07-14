package example.handle_errorresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;

	public void call() {

		try {
			String url = "http://localhost:8080/handle-servleterror/books/1";

			System.out.println("try get " + url);
			BookResource resource = restOperations.getForObject(url, BookResource.class);
			System.out.println("bookId: " + resource.getBookId());
			System.out.println("name: " + resource.getName());
			System.out.println("publishedDate: " + resource.getPublishedDate());
		} catch (HttpClientErrorException ex) {
			System.out.println(ex);
		} catch (HttpServerErrorException ex) {
			System.out.println(ex);
		}

		try {
			String url = "http://localhost:8080/handle-servleterror/books/raise-exception";

			System.out.println("try get " + url);
			BookResource resource = restOperations.getForObject(url, BookResource.class);
			System.out.println("bookId: " + resource.getBookId());
			System.out.println("name: " + resource.getName());
			System.out.println("publishedDate: " + resource.getPublishedDate());
		} catch (HttpClientErrorException ex) {
			System.out.println(ex);
		} catch (HttpServerErrorException ex) {
			System.out.println(ex);
		}

	}

}
