package example.inject.field_inject;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
