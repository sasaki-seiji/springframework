package example.di_javaconfig;

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
		return new UserServiceImpl(userRepository(), passwordEncoder());
	}
}
