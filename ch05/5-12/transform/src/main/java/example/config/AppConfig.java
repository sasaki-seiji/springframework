package example.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@SuppressWarnings("deprecation")
	@Bean
	List<Date> targetDateList() {
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(new Date(1959 - 1900, 12 - 1, 25 + 1));
		dateList.add(new Date(2018 - 1900, 6 - 1, 12 + 1));
		dateList.add(new Date(2018 - 1900, 6 - 1, 16 + 1));
		return dateList;
	}

}
