package example.scope.scope_prototype_java;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String rawPassword) {
		return rawPassword;
	}

}
