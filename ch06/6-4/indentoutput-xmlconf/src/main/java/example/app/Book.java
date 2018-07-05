package example.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Book {

	private String bookId;
	private String name;
	private List<String> authors = new ArrayList<>();
	private LocalDate publishedDate;
	private Publisher publisher;
	
	public String getBookId() { return bookId; }
	public void setBookId(String id) { this.bookId = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public List<String> getAuthors() { return authors; }
	public LocalDate getPublishedDate() { return publishedDate; }
	public void setPublishedDate(LocalDate date) { this.publishedDate = date; }
	public Publisher getPulisher() { return publisher; }
	public void setPublisher(Publisher publisher) { this.publisher = publisher; }
	
	public static class Publisher {
		private String name;
		private String tel;
		
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
		public String getTel() { return tel; }
		public void setTel(String tel) { this.tel = tel; }
	}
}
