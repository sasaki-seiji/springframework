package example.getforobject_string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class RestApiCaller {

	@Autowired
	RestOperations restOperations;
	
	public void call() {
		String resource = restOperations.getForObject(
			"http://localhost:8080/restapi/books/00000000-0000-0000-0000-000000000000",
			String.class);
		System.out.println(resource);
	}
	

}
