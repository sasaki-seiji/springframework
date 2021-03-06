package example.app;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void loadDummyData() {
		Book book = new Book();
		book.setBookId("00000000-0000-0000-0000-000000000000");
		book.setName("書籍名");
		book.setPublishedDate(LocalDate.of(2010, 4, 20));
		bookRepository.put(book.getBookId(), book);
	}
	
	public Book find(String bookId) {
		Book book = bookRepository.get(bookId);
		return book;
	}

	public Book create(Book book) {
		String bookId = UUID.randomUUID().toString();
		book.setBookId(bookId);
		bookRepository.put(bookId, book);
		return book;
	}

}
