package example.beanlifecycle.postconstruct_initmethod_java;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
