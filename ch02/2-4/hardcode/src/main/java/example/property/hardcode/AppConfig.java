package example.property.hardcode;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:ostgresql://localhost:5432/demo");
		dataSource.setUsername("demo");
		dataSource.setPassword("pass");
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
	}
}
