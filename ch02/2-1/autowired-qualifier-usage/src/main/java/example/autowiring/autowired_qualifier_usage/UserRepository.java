package example.autowiring.autowired_qualifier_usage;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
