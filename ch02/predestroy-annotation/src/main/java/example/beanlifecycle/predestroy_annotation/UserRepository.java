package example.beanlifecycle.predestroy_annotation;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
