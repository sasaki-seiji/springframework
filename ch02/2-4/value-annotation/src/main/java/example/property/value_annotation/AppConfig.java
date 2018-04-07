package example.property.value_annotation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource(
			@Value("${datasource.driver-class-name}") String driverClassName,
			@Value("${datasource.url}") String url,
			@Value("${datasource.username}") String username,
			@Value("${datasource.password}") String password) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
	}
}
