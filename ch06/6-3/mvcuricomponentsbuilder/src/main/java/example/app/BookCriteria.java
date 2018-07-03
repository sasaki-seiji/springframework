package example.app;

import java.time.LocalDate;

public class BookCriteria {

	private String name;
	private LocalDate publishedDate;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public LocalDate getPublishedDate() { return publishedDate; }
	public void setPublishedDate(LocalDate date) { this.publishedDate = date; }
}
