package example.app;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();
	private AtomicLong serialNo = new AtomicLong();
	
	@PostConstruct
	public void loadDummyData() {
		Book book = new Book();
		Long id = serialNo.incrementAndGet();
		book.setBookId(id.toString());
		book.setName("書籍名");
		bookRepository.put(book.getBookId(), book);
	}
	
	public Book find(String bookId) {
		Book book = bookRepository.get(bookId);
		return book;
	}
	
	public Book create(Book book) {
		Long id = serialNo.incrementAndGet();
		String bookId = id.toString();
		book.setBookId(bookId);
		bookRepository.put(bookId,  book);
		return book;
	}
	
	public Book update(Book book) {
		return bookRepository.put(book.getBookId(), book);
	}
}
