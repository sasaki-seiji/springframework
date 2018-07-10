package example.postforentity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
		
		ResponseEntity<Void> responseEntity = restOperations.postForEntity(
				"http://localhost:8080/restapi/books", resource, Void.class);

		HttpStatus httpStatus = responseEntity.getStatusCode();
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("status: " + httpStatus);
		System.out.println("headers: " + responseHeaders);
	}
	

}
