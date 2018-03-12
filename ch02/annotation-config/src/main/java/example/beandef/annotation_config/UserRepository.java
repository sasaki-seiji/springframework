package example.beandef.annotation_config;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
