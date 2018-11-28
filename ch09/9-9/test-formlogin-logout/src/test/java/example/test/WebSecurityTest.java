package example.test;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import example.config.AppConfig;
import example.config.WebMvcConfig;
import example.config.WebSecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(classes = {AppConfig.class, WebSecurityConfig.class}),
	@ContextConfiguration(classes = WebMvcConfig.class)
})
@WebAppConfiguration
public class WebSecurityTest {

	@Autowired
	WebApplicationContext webApplicationContext;
	
	MockMvc mockMvc;
	
	@Before
	public void setupMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(springSecurity())
				.build();
	}
	
	@Test
	public void testValidFormLogin() throws Exception {
		mockMvc.perform(
			formLogin().user("user").password("validPassword"))
			.andExpect(status().isFound()).andExpect(redirectedUrl("/"))
			.andExpect(authenticated().withRoles("USER"));
	}
	
	@Test
	public void testInvalidFormLogin() throws Exception {
		mockMvc.perform(
			formLogin().user("user").password("invalidPassword"))
			.andExpect(status().isFound()).andExpect(redirectedUrl("/login?error"))
			.andExpect(unauthenticated());
	}
	
	@WithMockUser
	@Test
	public void testLogout() throws Exception {
		mockMvc.perform(logout())
			.andExpect(status().isFound()).andExpect(redirectedUrl("/login?logout"))
			.andExpect(unauthenticated());
	}
}
