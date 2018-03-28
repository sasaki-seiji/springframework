package example.beanlifecycle.postconstruct_initializingbean;

public interface UserService {
	void register(User user, String rawPassword);
}
