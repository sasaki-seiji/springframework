package example.requestentity_uricomponentsbuilder;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;
	
	public void call() {

		String bookId = "00000000-0000-0000-0000-000000000000";

		RequestEntity<Void> requestEntity = RequestEntity
				.get(UriComponentsBuilder
						.fromUriString("http://localhost:8080/restapi/books/{bookId}")
						.buildAndExpand(bookId)
						.encode()
						.toUri())
				.header("X-Track-Id", UUID.randomUUID().toString())
				.build();
		
		ResponseEntity<BookResource> responseEntity =
				restOperations.exchange(requestEntity, BookResource.class);

		System.out.println("response: " + responseEntity);

		HttpStatus httpStatus = responseEntity.getStatusCode();
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		BookResource bookResource = responseEntity.getBody();
		System.out.println("status: " + httpStatus);
		System.out.println("headers: " + responseHeaders);
		System.out.println("bookResource.bookId: " + bookResource.getBookId());
		System.out.println("bookResource.name: " + bookResource.getName());
		System.out.println("bookResource.publishedDate: " + bookResource.getPublishedDate());
		
	}
	

}
