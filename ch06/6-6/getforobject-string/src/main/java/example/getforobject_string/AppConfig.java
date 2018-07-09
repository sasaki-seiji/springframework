package example.getforobject_string;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("example.getforobject_string")
public class AppConfig {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
