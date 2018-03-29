package example.config.separate_config_java;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DomainConfig.class, InfrastructureConfig.class})
public class AppConfig {
}
