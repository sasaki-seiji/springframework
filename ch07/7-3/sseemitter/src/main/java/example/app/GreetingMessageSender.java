package example.app;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class GreetingMessageSender {

	@Async
	public void send(SseEmitter emitter) 
			throws IOException, InterruptedException {
		
		emitter.send(SseEmitter.event()
				.id(UUID.randomUUID().toString()).data("Good Morning!"));
		TimeUnit.SECONDS.sleep(1);

		emitter.send(SseEmitter.event()
				.id(UUID.randomUUID().toString()).data("Hello!"));
		TimeUnit.SECONDS.sleep(1);

		emitter.send(SseEmitter.event()
				.id(UUID.randomUUID().toString()).data("Good Night!"));
		TimeUnit.SECONDS.sleep(1);

		emitter.complete();
	}
}
