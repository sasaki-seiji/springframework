package example.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Map<String, String> genderCodeList() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("men", "男性");
		map.put("women", "女性");
		return Collections.unmodifiableMap(map);
	}
}
