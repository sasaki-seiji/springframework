package example.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Map<String, String> prefectureCodeList() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("11", "埼玉");
		map.put("12", "千葉");
		return Collections.unmodifiableMap(map);
	}
}
