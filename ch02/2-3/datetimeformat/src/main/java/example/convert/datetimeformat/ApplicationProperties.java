package example.convert.datetimeformat;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${application.dateOfServiceStarting:}")
	@DateTimeFormat(pattern = "uuuu/M/d")
	private LocalDate dateOfServiceStarting;
	
	public LocalDate getDateOfServiceStarting()
	{
		return dateOfServiceStarting;
	}
}
