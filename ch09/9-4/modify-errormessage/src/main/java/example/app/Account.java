package example.app;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private boolean enabled;
	
	// 2018.11.16
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	
	private boolean admin;
	
	// 2018.11.14 add
	private String userUuid;
	private String lastName;
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	public boolean isAccountNonExpired() { return accountNonExpired; }
	public void setAccountNonExpired(boolean nonExpired) 
						{ this.accountNonExpired = nonExpired; }

	public boolean isCredentialsNonExpired() { return credentialsNonExpired; }
	public void setCredentialsNonExpired(boolean nonExpired) 
						{ this.credentialsNonExpired = nonExpired; }
	
	public boolean isAccountNonLocked() { return accountNonLocked; }
	public void setAccountNonLocked(boolean nonLocked)
						{ this.accountNonLocked = nonLocked; }

	public boolean isAdmin() { return admin; }
	public void setAdmin(boolean admin) { this.admin = admin; }

	public String getUserUuid() { return userUuid; }
	public void setUserUuid(String userUuid) { this.userUuid = userUuid; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
}
