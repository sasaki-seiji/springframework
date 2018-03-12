package example.inject.setter_xml;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
