package example.app;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchForm {
	@NotEmpty
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
}
