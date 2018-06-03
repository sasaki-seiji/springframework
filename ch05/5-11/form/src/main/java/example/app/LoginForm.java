package example.app;

import java.io.Serializable;

public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	private String password;
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}
