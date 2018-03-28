package example.autowiring.resource_propertyname;

public class Sha256PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - sha256";
	}

}
