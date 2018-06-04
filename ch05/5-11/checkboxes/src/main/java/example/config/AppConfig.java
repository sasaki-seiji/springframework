package example.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Map<String, String> hobbyCodeList() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("sport", "スポーツ");
		map.put("music", "音楽");
		return Collections.unmodifiableMap(map);
	}
}
