package example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("example.app")
// 2018.11.22 modify: move from WebSecurityConfig
// see https://stackoverflow.com/questions/29643183/spring-security-preauthorize-not-working
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/views/");	// see 5.9.2 for prefix()
			// 2018.11.18 modify "views/" to "/views/"
	}
}
