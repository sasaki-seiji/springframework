package example.autowiring.autowired_qualifier_name;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
