package example.app;

import java.time.LocalDate;

public class Book {

	private String bookId;
	private String name;
	private LocalDate publishedDate;
	
	public String getBookId() { return bookId; }
	public void setBookId(String id) { this.bookId = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public LocalDate getPublishedDate() { return publishedDate; }
	public void setPublishedDate(LocalDate date) { this.publishedDate = date; }

}
