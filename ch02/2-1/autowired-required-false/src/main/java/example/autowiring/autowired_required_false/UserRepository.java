package example.autowiring.autowired_required_false;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
