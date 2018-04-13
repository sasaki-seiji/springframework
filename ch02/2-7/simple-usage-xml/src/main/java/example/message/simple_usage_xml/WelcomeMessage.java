package example.message.simple_usage_xml;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
	@Autowired
	MessageSource messageSource;
	
	public void printWelcomeMessage() {
		String message = messageSource.getMessage(
				"welcome.message",
				new String[] {"佐々木"},
				Locale.JAPANESE);
		System.out.println(message);
	}
}
