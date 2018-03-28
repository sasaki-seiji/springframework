package example.beanlifecycle.destroydicontainer_close;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
