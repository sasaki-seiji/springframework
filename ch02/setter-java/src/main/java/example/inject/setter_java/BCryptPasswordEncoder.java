package example.inject.setter_java;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword;
	}

}
