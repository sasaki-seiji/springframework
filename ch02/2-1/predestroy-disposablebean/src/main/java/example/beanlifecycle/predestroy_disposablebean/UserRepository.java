package example.beanlifecycle.predestroy_disposablebean;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
