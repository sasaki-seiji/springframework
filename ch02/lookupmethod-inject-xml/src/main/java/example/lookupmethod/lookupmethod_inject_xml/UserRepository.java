package example.lookupmethod.lookupmethod_inject_xml;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
