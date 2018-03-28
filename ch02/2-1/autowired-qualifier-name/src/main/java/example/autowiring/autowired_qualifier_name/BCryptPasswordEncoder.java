package example.autowiring.autowired_qualifier_name;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - bcrypt";
	}

}
