package example.beanlifecycle.postconstruct_initializingbean;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
