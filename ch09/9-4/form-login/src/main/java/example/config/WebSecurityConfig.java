package example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
            http.formLogin()
            		.loginPage("/login")
            		.permitAll();
            http.authorizeRequests()
            		.anyRequest().authenticated();
    }
	
	// 2018.11.06 add: 
	// see https://docs.spring.io/spring-security/site/docs/4.2.5.RELEASE/apidocs/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure-org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder-
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		// enable in memory based authentication with a user named
		// "guest" and "admin"
		.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder())
		.withUser("guest").password("guest").roles("USER").and()
		.withUser("admin").password("admin").roles("USER", "ADMIN");
	}

	// 2018.11.06 add: 
	// see https://docs.spring.io/spring-security/site/docs/4.2.5.RELEASE/apidocs/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure-org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder-
	// Expose the UserDetailsService as a Bean
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	// 2018.11.06 add
	@Bean
	PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance(); // tempolary use
	}

}
