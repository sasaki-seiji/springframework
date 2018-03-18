package example.autowiring.resource_propertyname;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - bcrypt";
	}

}
