package example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan("example.app")
@EnableWebSecurity
// 2018.11.22 modify: move to WebMvcConfig
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	// see https://docs.spring.io/spring-security/site/docs/5.1.1.RELEASE/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure-org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder-
	//		https://docs.spring.io/spring-security/site/docs/5.1.1.RELEASE/api/org/springframework/security/config/annotation/authentication/builders/AuthenticationManagerBuilder.html
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
            http.formLogin()
            		.loginPage("/login")
            		.permitAll();
            http.logout()
            		.permitAll();
            http.authorizeRequests()
            		.anyRequest().authenticated();
    }
}
