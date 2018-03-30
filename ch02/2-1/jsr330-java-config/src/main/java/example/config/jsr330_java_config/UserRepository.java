package example.config.jsr330_java_config;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
