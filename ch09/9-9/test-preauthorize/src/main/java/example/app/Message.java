package example.app;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String message;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
}
