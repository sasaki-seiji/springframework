package example.app;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String id;

	@NotEmpty
	private String name;

	public Account() { }
	public Account(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

}
