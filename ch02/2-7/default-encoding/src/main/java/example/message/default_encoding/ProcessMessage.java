package example.message.default_encoding;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;

@Component
public class ProcessMessage {
	@Autowired
	MessageSource messageSource;
	
	public void printDoneMessage() {
		MessageSourceResolvable functionName = new DefaultMessageSourceResolvable(
				"functionName.userRegistration");
		String message = messageSource.getMessage(
				"result.succeed",
				new MessageSourceResolvable[] {functionName},
				Locale.JAPANESE);
		System.out.println(message);
	}

}
