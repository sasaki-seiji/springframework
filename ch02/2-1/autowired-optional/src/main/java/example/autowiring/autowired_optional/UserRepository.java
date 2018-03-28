package example.autowiring.autowired_optional;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
