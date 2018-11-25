package example.config;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.DelegatingAccessDeniedHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import example.app.SessionExpiredDetectingLoginUrlAuthenticationEntryPoint;

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
            		.antMatchers("/admin/accounts/**").hasRole("ACCOUNT_MANAGER")
            		.antMatchers("/admin/**").hasRole("ADMIN")
            		.anyRequest().authenticated();

            // 2018.11.24 change
            http.exceptionHandling()
            		.authenticationEntryPoint(authenticationEntryPoint())
            		.accessDeniedHandler(accessDeniedHandler());
	}

	// 2018.11.25 add
	@Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new SessionExpiredDetectingLoginUrlAuthenticationEntryPoint("/login");
    }

	// 2018.11.24 add
	@Bean
	AccessDeniedHandler accessDeniedHandler() {
		LinkedHashMap<Class<? extends AccessDeniedException>, AccessDeniedHandler> 
			map = new LinkedHashMap<>();

		AccessDeniedHandlerImpl handler1 = new AccessDeniedHandlerImpl();
		handler1.setErrorPage("/views/authorizationServiceError.jsp");
		map.put(AuthorizationServiceException.class, handler1);

		AccessDeniedHandlerImpl handler2 = new AccessDeniedHandlerImpl();
		handler2.setErrorPage("/views/invalidCsrfTokenError.jsp");
		map.put(InvalidCsrfTokenException.class, handler2);

		AccessDeniedHandlerImpl handler3 = new AccessDeniedHandlerImpl();
		handler3.setErrorPage("/views/missingCsrfTokenError.jsp");
		map.put(MissingCsrfTokenException.class, handler3);

		AccessDeniedHandlerImpl defaultHandler = new AccessDeniedHandlerImpl();
		defaultHandler.setErrorPage("/views/accessDeniedError.jsp");

		return new DelegatingAccessDeniedHandler(map, defaultHandler);
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
		.withUser("admin").password("admin").roles("USER", "ADMIN").and()
		.withUser("account-manager").password("account-manager")
				.roles("USER", "ADMIN", "ACCOUNT_MANAGER");
	}

	// 2018.11.11 add: needed for spring security 5
	// see https://www.harinathk.com/spring/no-passwordencoder-mapped-id-null/
	@SuppressWarnings("deprecation")
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // temporary use
	}

}
