package com.example.bean_junit;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.example.domain.MessageService;

public class MessageServiceTest {
	@Test
	public void testGetMessage() {
		MessageService service = new MessageService();
		String actualMessage = service.getMessage();
		assertThat(actualMessage, is("Hello!"));
	}
}
