package example.message.multi_languages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
	@Autowired
	MessageSource messageSource;
	
	public void printWelcomeMessage(String name) {
		String message = messageSource.getMessage(
				"welcome.message",
				new String[] {name},
				Locale.JAPANESE);
		System.out.println(message);
	}
}
