package example.convert.datetimeformat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Bean
	public ConversionService conversionService() {
		return new DefaultFormattingConversionService();
	}
}
