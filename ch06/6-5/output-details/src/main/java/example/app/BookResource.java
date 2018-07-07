package example.app;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookResource implements Serializable {

	private static final long serialVersionUID = 1L;

	private String bookId;
	
	@NotEmpty
	private String name;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishedDate;
	
	public String getBookId() { return bookId; }
	public void setBookId(String id) { this.bookId = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public LocalDate getPublishedDate() { return publishedDate; }
	public void setPublishedDate(LocalDate date) { this.publishedDate = date; }
}
