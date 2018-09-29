package example.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import example.app.WelcomeController;

public class StandaloneWelcomeControllerTest {

	MockMvc mockMvc;
	
	@Before
	public void setupMockMvc() {
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(new WelcomeController()).build();
	}
	
	@Test
	public void testHome() throws Exception {
		/* 2018.09.29: modify
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/index.jsp"));
		*/
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andDo(print());
	}

}
