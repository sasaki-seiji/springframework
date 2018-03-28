package example.beanlifecycle.postconstruct_initmethod_xml;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
