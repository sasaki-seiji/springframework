package example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
	
	// 2018.11.06 add: 
	// see https://docs.spring.io/spring-security/site/docs/5.1.1.RELEASE/api/https://docs.spring.io/spring-security/site/docs/5.1.1.RELEASE/api/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		// enable in memory based authentication with a user named
		// "guest" and "admin"
		.inMemoryAuthentication()
		.withUser("guest").password("guest").roles("USER").and()
		.withUser("admin").password("admin").roles("USER", "ADMIN");
	}

	// 2018.11.11 add: needed for spring security 5
	// see https://www.harinathk.com/spring/no-passwordencoder-mapped-id-null/
	@SuppressWarnings("deprecation")
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // tempolary use
	}

}
