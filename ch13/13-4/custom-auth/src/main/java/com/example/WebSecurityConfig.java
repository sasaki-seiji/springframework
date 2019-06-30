package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation") // for NoOpPasswordEncoder
@Configuration
// 2019.06.30 remove. see: https://modernjava.io/upgrading-to-spring-boot-2-0-my-experience/
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// see https://qiita.com/nenokido2000/items/22a97a26a5858ddb164f
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll();
		http.logout()
				.logoutUrl("/logout")
				.permitAll()
				.logoutSuccessUrl("/login?logout")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true);
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN", "USER")
			.and()
			.withUser("user").password("user").roles("USER");
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // tempolary use
	}
}
