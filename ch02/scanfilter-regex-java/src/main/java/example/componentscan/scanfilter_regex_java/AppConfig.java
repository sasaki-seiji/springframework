package example.componentscan.scanfilter_regex_java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
	basePackages = "example.componentscan.scanfilter_regex_java",
	includeFilters = {
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = {".+DomainService$"})
})
public class AppConfig {
}
