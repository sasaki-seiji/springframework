package example.beanlifecycle.predestroy_destroymethod_java;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
