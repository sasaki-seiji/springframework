package example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// 2019.05.29 add: see 2.4.1
@PropertySource("classpath:application.properties")
public class AppConfig {

}
