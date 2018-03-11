package example.di_annotationconfig;

import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword;
	}

}
