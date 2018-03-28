package example.inject.constructor_argname;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
