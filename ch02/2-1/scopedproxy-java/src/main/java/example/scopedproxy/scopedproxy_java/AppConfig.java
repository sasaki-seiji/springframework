package example.scopedproxy.scopedproxy_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	PasswordEncoder passwordEncoder() {
		return new ThreadUnsafePasswordEncoder();
	}
}
