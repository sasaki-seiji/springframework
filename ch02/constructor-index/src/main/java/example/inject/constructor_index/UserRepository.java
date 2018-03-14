package example.inject.constructor_index;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
