package example.di_javaconfig;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
