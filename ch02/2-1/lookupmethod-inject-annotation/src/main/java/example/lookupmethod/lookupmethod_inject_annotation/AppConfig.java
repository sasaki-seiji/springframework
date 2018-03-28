package example.lookupmethod.lookupmethod_inject_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean
	@Scope("prototype")
	PasswordEncoder passwordEncoder() {
		return new ThreadUnsafePasswordEncoder();
	}
}
