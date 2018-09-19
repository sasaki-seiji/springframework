package example.app;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String bookId;
	private String name;
	
	public String getBookId() { return bookId; }
	public void setBookId(String id) { this.bookId = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
