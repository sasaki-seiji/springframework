package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
// 2019.06.07 add
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
// 2019.06.07 add
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	@LocalServerPort
	int port;
	
	@Test
	public void contextLoads() {
		assertThat(restTemplate.getForObject("http://localhost:" +
				port, String.class), is("Hello World!"));
	}

}
