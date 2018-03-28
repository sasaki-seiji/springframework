package example.autowiring.autowired_lightweight_annotation;

public class Sha256PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword + " - sha256";
	}

}
