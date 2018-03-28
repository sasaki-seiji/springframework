package example.lookupmethod.lookupmethod_container;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
