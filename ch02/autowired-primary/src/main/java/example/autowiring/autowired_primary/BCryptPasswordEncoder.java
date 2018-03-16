package example.autowiring.autowired_primary;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - bcrypt";
	}

}
