package example.autowiring.autowired_collection_bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean
	List<IF> ifList() {
		return Arrays.asList(new IntIF1(), new IntIF2(), new StringIF());
	}
	
	@Bean
	Map<String, IF> ifMap() {
		Map<String, IF> map = new HashMap<>();
		map.put("intIF1", new IntIF1());
		map.put("intIF2", new IntIF2());
		map.put("stringIF", new StringIF());
		return map;
	}
}