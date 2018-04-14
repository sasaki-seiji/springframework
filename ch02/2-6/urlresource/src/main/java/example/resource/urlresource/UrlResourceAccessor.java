package example.resource.urlresource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StreamUtils;

public class UrlResourceAccessor {
	public void accessResource() throws IOException {
		Resource greetingResource =
				new UrlResource("http://localhost:3000/greeting.json");
		try (InputStream in = greetingResource.getInputStream()) {
			String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		}
	}
}
