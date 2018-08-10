package com.example.bean_integration_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.AppConfig;
import com.example.domain.MessageService;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MessageServiceIntegrationTest {

	@Autowired
	MessageService service;
	
	@Test
	public void testGetMessageByCode() {
		String actualMessage = service.getMessageByCode("greeting");
		assertThat(actualMessage, is("Hello!!"));
	}
}
