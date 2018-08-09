package com.example.bean_mockito;


import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

// 2018.08.09 change: deprecated
//import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.context.MessageSource;
import com.example.domain.MessageService;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {
	
	@InjectMocks
	MessageService service;
	@Mock
	MessageSource mockMessageSource;
	
	@Test
	public void testGetMessageByCode() {
		
		doReturn("Hello!").when(mockMessageSource)
			.getMessage("greeting", null, Locale.getDefault());
		
		String actualMessage = service.getMessageByCode("greeting");
		assertThat(actualMessage, is("Hello!"));
	}
}
