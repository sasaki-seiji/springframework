package example.di_javaconfig;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword;
	}

}
