package example.componentscan.scanfilter_notusedefaultfilters_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
	basePackages = "example.componentscan.scanfilter_notusedefaultfilters_java",
	useDefaultFilters = false,
	includeFilters = {
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = {".+DomainService$"})
})
public class AppConfig {
	@Bean // need because @Component of CollectionService class does not work !
	CollectionService collectionService() {
		return new CollectionService();
	}
}
