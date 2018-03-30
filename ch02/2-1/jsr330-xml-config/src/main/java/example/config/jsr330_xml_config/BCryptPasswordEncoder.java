package example.config.jsr330_xml_config;

import javax.inject.Named;

@Named
public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword;
	}

}
