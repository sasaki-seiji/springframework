package example.inject.setter_java;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
