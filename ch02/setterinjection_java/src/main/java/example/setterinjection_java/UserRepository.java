package example.setterinjection_java;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
