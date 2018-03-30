package example.config.jsr330_java_config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver;

@ComponentScan(basePackages = "example.config.jsr330_java_config",
		scopeResolver = Jsr330ScopeMetadataResolver.class)
public class AppConfig {
	
}
