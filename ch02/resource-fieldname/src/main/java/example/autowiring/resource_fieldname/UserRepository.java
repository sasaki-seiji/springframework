package example.autowiring.resource_fieldname;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
