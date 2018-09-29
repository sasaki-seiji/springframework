package example.test;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import example.app.Book;
import example.app.BookService;
import example.app.BooksRestController;

public class StandaloneBooksRestControllerTest {

	MockMvc mockMvc;
	
	@InjectMocks
	BooksRestController controller;
	
	@Mock
	BookService mockBookService;
	
	@Before
	public void setupMockMvc() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
		Book book = new Book();
		book.setBookId("001");
		book.setName("Spring徹底入門");
		book.setPublishedDate(LocalDate.of(2016, 7, 20));
		List<Book> list = new ArrayList<Book>();
		list.add(book);

		when(mockBookService.findAllByCriteria(argThat(criteria -> true)))
		.thenReturn(list);

		mockMvc.perform(get("/books"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
					.string("[{\"bookId\":\"001\",\"name\":\"Spring徹底入門\",\"publishedDate\":\"2016-07-20\"}]"))
				.andDo(log());
	}

}
