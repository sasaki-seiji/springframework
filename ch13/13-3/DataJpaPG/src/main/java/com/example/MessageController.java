package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {

	@Autowired
	MessageRepository messageRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Message> getMessage() {
		return messageRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Message postMessage(@RequestBody Message message) {
		return messageRepository.save(message);
	}
}
