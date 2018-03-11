package example.di_annotationconfig;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
