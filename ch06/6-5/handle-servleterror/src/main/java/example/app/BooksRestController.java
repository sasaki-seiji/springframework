package example.app;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BooksRestController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(path = "{bookId}", method = RequestMethod.GET)
	public BookResource getBook(@PathVariable String bookId) {

		Book book = bookService.find(bookId);
		if (book == null) {
			throw new BookResourceNotFoundException(bookId);
		}
		
		BookResource resource = new BookResource();
		resource.setBookId(book.getBookId());
		resource.setName(book.getName());
		resource.setPublishedDate(book.getPublishedDate());
		
		return resource;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createBook(
			@Validated @RequestBody BookResource newResource,
			UriComponentsBuilder uriBuilder){
		
		Book newBook = new Book();
		newBook.setName(newResource.getName());
		newBook.setPublishedDate(newResource.getPublishedDate());
		
		Book createdBook = bookService.create(newBook);
		
		URI resourceUri = MvcUriComponentsBuilder.relativeTo(uriBuilder)
				.withMethodCall(
					on(BooksRestController.class).getBook(createdBook.getBookId()))
				.build()
				.encode()
				.toUri();

		return ResponseEntity.created(resourceUri).build();
	}
	
	@RequestMapping(path = "raise-exception")
	public BookResource raiseException() {

		throw new RuntimeException("artificial exception");
	}
	
	// 2018.07.16 add for timeout test
	@RequestMapping(path = "slow/{bookId}", method = RequestMethod.GET)
	public BookResource getBookSlow(@PathVariable String bookId) {

		// delay 5000ms
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Book book = bookService.find(bookId);
		if (book == null) {
			throw new BookResourceNotFoundException(bookId);
		}
		
		BookResource resource = new BookResource();
		resource.setBookId(book.getBookId());
		resource.setName(book.getName());
		resource.setPublishedDate(book.getPublishedDate());
		
		return resource;
	}
}
