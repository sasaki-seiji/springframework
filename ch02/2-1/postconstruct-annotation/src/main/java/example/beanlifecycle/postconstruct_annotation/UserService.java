package example.beanlifecycle.postconstruct_annotation;

public interface UserService {
	void register(User user, String rawPassword);
}
