package example.test;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import example.config.TransactionManagerConfig;
import example.config.WebMvcConfig;
import example.config.WebSecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(classes = {TransactionManagerConfig.class, WebSecurityConfig.class}),
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
	public void testPostMessageByAdminRole() throws Exception {
		mockMvc
		.perform(
			post("/message/add")
				.contentType("application/x-www-form-urlencoded")
				.content("message=Message")
				.with(user("admin").roles("ADMIN"))
				.with(csrf()))
		.andExpect(status().isFound()).andExpect(redirectedUrl("/message/list"));
	}
	
	@Test
	public void testPostMessageByUserRole() throws Exception {
		mockMvc
		.perform(
			post("/message/add")
				.contentType("application/x-www-form-urlencoded")
				.content("message=Message")
				.with(user("user").roles("USER"))
				.with(csrf()))
		.andExpect(status().isForbidden());
	}

	@Test
	public void testInvalidCsrfToken() throws Exception {
		mockMvc
		.perform(
			post("/message/add")
				.contentType("application/x-www-form-urlencoded")
				.content("message=Message")
				.with(user("admin").roles("ADMIN"))
				.with(csrf().useInvalidToken()))
		.andExpect(status().isForbidden());
	}

}
