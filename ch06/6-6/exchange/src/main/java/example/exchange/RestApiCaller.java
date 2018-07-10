package example.exchange;

import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
		
		RequestEntity<BookResource> requestEntity = RequestEntity
				.post(URI.create("http://localhost:8080/restapi/books"))
				.contentType(MediaType.APPLICATION_JSON)
				.header("X-Track-Id", UUID.randomUUID().toString())
				.body(resource);
		
		ResponseEntity<Void> responseEntity =
				restOperations.exchange(requestEntity, Void.class);

		System.out.println("response: " + responseEntity);
	}
	

}
