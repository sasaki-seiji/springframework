package example.resource.resourceloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class ResourceAccessor {
	@Autowired
	ResourceLoader resourceLoader;
	
	public void accessResource() throws IOException {
		Resource greetingResource =
				resourceLoader.getResource("http://localhost:3000/greeting.json");
		try (InputStream in = greetingResource.getInputStream()) {
			String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		}
	}
}
