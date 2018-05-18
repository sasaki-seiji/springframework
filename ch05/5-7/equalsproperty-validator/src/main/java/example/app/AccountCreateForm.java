package example.app;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

@EqualsPropertyValues(property = "password", comparingProperty = "reEnteredPassword")
public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@NotEmpty
	private String password;
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	@NotEmpty
	private String reEnteredPassword;
	public String getReEnteredPassword() { return reEnteredPassword; }
	public void setReEnteredPassword(String reEnteredPassword) 
		{ this.reEnteredPassword = reEnteredPassword; }

}
