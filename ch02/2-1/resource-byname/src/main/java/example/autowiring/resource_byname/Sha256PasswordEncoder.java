package example.autowiring.resource_byname;

public class Sha256PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - sha256";
	}

}
