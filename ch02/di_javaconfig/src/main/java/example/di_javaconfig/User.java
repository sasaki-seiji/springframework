package example.di_javaconfig;

public class User {
	private String username;
	private String password;
	
	public User(String username) {
		this.username = username;
	}
	
	public String getUsername() { return this.username; }
	public void setPassword(String password) { this.password = password; }
}
