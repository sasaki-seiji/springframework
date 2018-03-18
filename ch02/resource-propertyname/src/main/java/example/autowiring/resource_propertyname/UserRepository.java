package example.autowiring.resource_propertyname;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
