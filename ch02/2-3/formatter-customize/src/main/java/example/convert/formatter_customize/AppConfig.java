package example.convert.formatter_customize;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Bean
	public ConversionService conversionService() {
		DefaultFormattingConversionService conversionService 
			= new DefaultFormattingConversionService();
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setDateFormatter(DateTimeFormatter.ISO_DATE);
		registrar.registerFormatters(conversionService);
		return conversionService;
	}
}
