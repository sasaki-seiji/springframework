package example.inject.setter_annotation;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
