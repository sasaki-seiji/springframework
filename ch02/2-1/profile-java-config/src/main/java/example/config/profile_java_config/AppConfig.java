package example.config.profile_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
	
	@Bean(name = "dataSource")
	@Profile("development")
	DataSource dataSourceForDev() {
		return new DataSourceForDev();
	}

	@Bean(name = "dataSource")
	@Profile("production")
	DataSource dataSourceForProd() {
		return new DataSourceForProd();
	}

}
