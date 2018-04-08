package example.convert.property_editor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${application.healthCheck:no}")
	private boolean healthCheckEnabled;
	
	public boolean getHealthCheckEnabled()
	{
		return healthCheckEnabled;
	}
}
