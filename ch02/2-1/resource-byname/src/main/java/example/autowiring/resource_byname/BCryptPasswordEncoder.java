package example.autowiring.resource_byname;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - bcrypt";
	}

}
