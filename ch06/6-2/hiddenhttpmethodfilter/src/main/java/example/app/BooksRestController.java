package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BooksRestController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(path = "{bookId}", method = RequestMethod.GET)
	public Book getBook(@PathVariable String bookId) {
		System.out.println("GET /books/" + bookId);

		Book book = bookService.find(bookId);
		System.out.println("GET /books/" + bookId);
		return book;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Book createBook(
			@Validated @RequestBody Book book) {
		System.out.println("POST /books");
		Book createdBook = bookService.create(book);
		return createdBook;
	}
	
	@RequestMapping(path = "{bookId}", method = RequestMethod.PUT)
	public Book put(@PathVariable String bookId,
					@Validated @RequestBody Book book) {
		System.out.println("PUT /books/" + bookId);
		bookService.update(book);
		book = bookService.find(book.getBookId());
		return book;
	}
}
