package example.componentscan.scanfilter_exclude_java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
	basePackages = "example.componentscan.scanfilter_exclude_java",
	includeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DomainService.class})
	},
	excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.ANNOTATION, pattern = {Exclude.class})
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Exclude.class})
	}
)
public class AppConfig {
}
