package example.beanlifecycle.predestroy_destroymethod_xml;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
