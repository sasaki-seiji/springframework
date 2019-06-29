package example.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import example.app.MessageService;
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
	MessageService service;
	
	//WebApplicationContext webApplicationContext;
	
	@WithMockUser(username = "admin", roles = "ADMIN")
	@Test
	public void testAddMessageByAdminRole() throws Exception {
		int count = service.addMessage("Message!");
		assertThat(count, is(1));
	}
	
	@WithMockUser(username = "user", roles = "USER")
	@Test(expected = AccessDeniedException.class)
	public void testAddMessageByUserRole() throws Exception {
		service.addMessage("Message!");
	}
	
	@WithUserDetails("admin")
	@Test
	public void testAddMessageByAdmin() throws Exception {
		int count = service.addMessage("Message!");
		assertThat(count, is(1));
	}
	
	@WithUserDetails("user")
	@Test(expected = AccessDeniedException.class)
	public void testAddMessageByUser() throws Exception {
		service.addMessage("Message!");
	}
	
	// 2019.06.30 add
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void testAddMessageByNobody() throws Exception {
		service.addMessage("Message!");
	}
	
}
