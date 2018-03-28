package example.beanlifecycle.destroydicontainer_shutdownhook;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
