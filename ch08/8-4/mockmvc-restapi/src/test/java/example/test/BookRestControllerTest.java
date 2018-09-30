package example.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import example.config.AppConfig;
import example.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(classes = AppConfig.class),
	@ContextConfiguration(classes = WebMvcConfig.class)
})
@WebAppConfiguration
public class BookRestControllerTest {

	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void setupMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.addFilters(new CharacterEncodingFilter("UTF-8"))
				.build();
	}
	
	@Test
	public void testBooks_1() throws Exception {
		mockMvc.perform(get("/books")
					.param("name", "Spring")
					.accept(MediaType.APPLICATION_JSON)
					.header("X-Track-Id", UUID.randomUUID().toString()))
				.andExpect(status().isOk());
	}

	@Test
	public void testBooks_2() throws Exception {
		mockMvc.perform(get("/books"))
				.andExpect(status().isOk())
				.andExpect(content()
					.string("[{\"bookId\":\"00000000-0000-0000-0000-000000000000\",\"name\":\"書籍名\",\"publishedDate\":\"2010-04-20\"}]"))
				.andDo(log());
	}

	@Test
	public void testGetBook() throws Exception {
		mockMvc.perform(get("/books/00000000-0000-0000-0000-000000000000"))
				.andExpect(status().isOk())
				.andExpect(content()
					.string("{\"bookId\":\"00000000-0000-0000-0000-000000000000\",\"name\":\"書籍名\",\"publishedDate\":\"2010-04-20\"}"));
	}

	@Test
	public void testCreateBook() throws Exception {
		String location = mockMvc.perform(post("/books")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"name\":\"Spring徹底入門\",\"publishedDate\":\"2016-07-20\"}"))
				.andDo(print())
				.andExpect(status().is(201))
				.andExpect(header().exists("Location"))
				.andReturn().getResponse().getHeader("Location");
		
		System.out.println("location: " + location);
		int index = location.lastIndexOf('/');
		String id = location.substring(index+1);
		System.out.println("id: " + id);
		
		mockMvc.perform(get("/books/" + id))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content()
					.string("{\"bookId\":\"" + id + "\",\"name\":\"Spring徹底入門\",\"publishedDate\":\"2016-07-20\"}"));

	}

}
