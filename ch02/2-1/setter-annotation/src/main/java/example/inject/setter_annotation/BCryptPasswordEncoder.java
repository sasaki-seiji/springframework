package example.inject.setter_annotation;

import org.springframework.stereotype.Component;
import example.inject.setter_annotation.PasswordEncoder;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword;
	}

}
