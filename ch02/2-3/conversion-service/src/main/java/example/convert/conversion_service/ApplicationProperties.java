package example.convert.conversion_service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${application.dateOfServiceStarting:}")
	private LocalDate dateOfServiceStarting;
	
	public LocalDate getDateOfServiceStarting()
	{
		return dateOfServiceStarting;
	}
}
