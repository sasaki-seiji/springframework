package example.autowiring.autowired_qualifier_usage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class AppConfig {
	
	@Bean(name = "lightweight")
	PasswordEncoder sha256PasswordEncoder() {
		return new Sha256PasswordEncoder();
	}

	@Bean
	@Primary
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
