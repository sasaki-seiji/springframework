package example.autowiring.resource_byname;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
