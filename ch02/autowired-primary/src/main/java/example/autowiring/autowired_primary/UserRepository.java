package example.autowiring.autowired_primary;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
