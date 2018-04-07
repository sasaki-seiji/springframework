package example.property.value_annotation;

public interface DataSource {
	void setDriverClassName(String className);
	void setUrl(String url);
	void setUsername(String userName);
	void setPassword(String password);
	void setDefaultAutoCommit(boolean autoCommit);
	void close();
}
