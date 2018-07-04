package example.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan("example.app")
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	ObjectMapper objectMapper() {
		return Jackson2ObjectMapperBuilder.json()
				.indentOutput(true)
				.build();
	}
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		HttpMessageConverter<?> converter 
			= new MappingJackson2HttpMessageConverter(objectMapper());
		converters.add(0, converter);
	}
}
