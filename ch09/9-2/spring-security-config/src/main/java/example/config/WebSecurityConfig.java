package example.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
			.antMatchers("/resources/**");
	}
	/* 2018.10.08: 上記の代わりに以下でも動作する
	@Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/**").authenticated();
            http.formLogin();
    }
    */
}
