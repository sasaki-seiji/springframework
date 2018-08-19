package com.example.default_beandef_xmlconf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.MessageService;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MessageServiceIntegrationTest {

	@Autowired
	MessageService service;
	
	@Test
	public void testGetMessageByCode() {
		String actualMessage = service.getMessageByCode("greeting");
		assertThat(actualMessage, is("Hello!!"));
	}
}
