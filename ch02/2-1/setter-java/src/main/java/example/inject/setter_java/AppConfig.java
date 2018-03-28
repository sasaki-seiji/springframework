package example.inject.setter_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserService userService() {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserRepository(userRepository());
		userService.setPasswordEncoder(passwordEncoder());
		return userService;
	}
}
