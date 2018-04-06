package example.property.hardcode;

public class BasicDataSource implements DataSource {

	private String className;
	private String url;
	private String userName;
	private String password;
	private boolean autoCommit;
	
	@Override
	public void setDriverClassName(String className) {
		this.className = className;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void setUsername(String userName) {
		this.userName = userName;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setDefaultAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

	@Override
	public void close() {
		System.out.println("BasicDataSource: closed");
	}

	@Override
	public String toString() {
		return "driverClass: " + className + "\n"
				+ "url: " + url + "\n"
				+ "userName: " + userName + "\n"
				+ "password: " + password + "\n"
				+ "autoCommit: " + autoCommit + "\n";
	}
}
