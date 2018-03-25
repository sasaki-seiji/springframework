package example.beanlifecycle.postconstruct_initmethod_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean(initMethod = "populateCache")
	UserService userService() {
		return new UserServiceImpl(userRepository());
	}
}
