package example.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		for(String author : book.getAuthors()) {
			resource.getAuthors().add(author);
		}
		resource.setPublishedDate(book.getPublishedDate());
		BookResource.Publisher publisher = new BookResource.Publisher();
			publisher.setName(book.getPulisher().getName());
			publisher.setTel(book.getPulisher().getTel());
		resource.setPublisher(publisher);
		
		return resource;
	}
	
}
