package example.beanlifecycle.postconstruct_annotation;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
