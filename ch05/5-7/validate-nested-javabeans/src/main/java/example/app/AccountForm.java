package example.app;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(min = 1, max = 50)
	private String name;

	@NotEmpty
	@Email
	private String email;
	
	public AccountForm(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public AccountForm() { }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}
