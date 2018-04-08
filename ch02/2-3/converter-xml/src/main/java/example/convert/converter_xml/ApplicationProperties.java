package example.convert.converter_xml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${application.adminEmail:}")
	private EmailValue adminEmail;
	
	public EmailValue getAdminEmail()
	{
		return adminEmail;
	}
}
