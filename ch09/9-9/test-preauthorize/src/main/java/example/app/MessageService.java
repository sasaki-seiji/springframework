package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	@Transactional(readOnly = true)
	public List<Message> getAllMessages() {
		return messageRepository.getAllMessages();
	}
	
	@PreAuthorize("hasRole('ADMIN')")	// see 9.5.5
	public int addMessage(String message) {
		return messageRepository.addMessage(message);
	}
}
