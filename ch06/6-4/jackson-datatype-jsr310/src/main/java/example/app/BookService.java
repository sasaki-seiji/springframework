package example.app;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void loadDummyData() {
		Book book = new Book();
		book.setBookId("1");
		book.setName("書籍名");
		book.getAuthors().add("著者A");
		book.setPublishedDate(LocalDate.of(2016, 4, 1));
		Book.Publisher publisher = new Book.Publisher();
			publisher.setName("翔泳社");
			publisher.setTel("03-xxxx-xxxx");
		book.setPublisher(publisher);
		bookRepository.put(book.getBookId(), book);
	}
	
	public Book find(String bookId) {
		Book book = bookRepository.get(bookId);
		return book;
	}

}
