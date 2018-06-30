package example.app;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
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
			@Validated @RequestBody BookResource newResource){
		
		Book newBook = new Book();
		newBook.setName(newResource.getName());
		newBook.setPublishedDate(newResource.getPublishedDate());
		
		Book createdBook = bookService.create(newBook);
		
		String resourceUri = 
				"http://localhost:8080/restapi/books/" + createdBook.getBookId();

		return ResponseEntity.created(URI.create(resourceUri)).build();
	}
	
	@RequestMapping(path = "{bookId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(@PathVariable String bookId,
			@Validated @RequestBody BookResource resource) {
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setName(resource.getName());
		book.setPublishedDate(resource.getPublishedDate());
		
		bookService.update(book);
	}
	
	@RequestMapping(path = "{bookId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String bookId) {
		bookService.delete(bookId);
	}
}
