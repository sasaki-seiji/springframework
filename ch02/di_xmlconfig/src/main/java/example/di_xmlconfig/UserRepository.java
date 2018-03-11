package example.di_xmlconfig;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
