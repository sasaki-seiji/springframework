package example.app;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private boolean enabled;
	private boolean admin;
	
	// 2018.11.14 add
	private String userUuid;
	private String lastName;
	
	// 2018.11.23 add
	private String departmentCode;
	private boolean departmentManager;
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }
	
	public boolean isAdmin() { return admin; }
	public void setAdmin(boolean admin) { this.admin = admin; }

	public String getUserUuid() { return userUuid; }
	public void setUserUuid(String userUuid) { this.userUuid = userUuid; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getDepartmentCode() { return departmentCode; }
	public void setDepartmentCode(String code) { this.departmentCode = code; }

	public boolean isDepartmentManager() { return departmentManager; }
	public void setDepartmentManager(boolean manager) 
							{ this.departmentManager = manager; }
}
