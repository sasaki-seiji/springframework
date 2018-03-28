package example.beanlifecycle.predestroy_destroymethod_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean(destroyMethod = "clearCache")
	UserService userService() {
		return new UserServiceImpl(userRepository());
	}
}
