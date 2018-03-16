package example.autowiring.autowired_qualifier_usage;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - bcrypt";
	}

}
