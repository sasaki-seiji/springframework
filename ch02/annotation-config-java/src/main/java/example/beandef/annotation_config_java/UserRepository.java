package example.beandef.annotation_config_java;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
