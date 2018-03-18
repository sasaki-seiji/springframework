package example.autowiring.autowired_lightweight_annotation;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
