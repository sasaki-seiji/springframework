package example.inject.constructor_argname;

public class User {
	private String username;
	private String password;
	
	public User(String username) {
		this.username = username;
	}
	
	public String getUsername() { return this.username; }
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
}
