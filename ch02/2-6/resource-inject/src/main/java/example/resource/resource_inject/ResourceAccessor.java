package example.resource.resource_inject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class ResourceAccessor {
	@Value("${resource.greeting:http://localhost:3000/greeting.json}")
	Resource greetingResource;
	
	public void accessResource() throws IOException {
		try (InputStream in = greetingResource.getInputStream()) {
			String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		}
	}
}
