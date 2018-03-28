package example.beanlifecycle.destroydicontainer_trywithresources;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
