package example.config.separate_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
	@Bean
	UserService userService() {
		return new UserService();
	}
}
