package example.app;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountSearchForm {

	@NotEmpty
	private String name;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
