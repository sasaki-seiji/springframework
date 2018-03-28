package example.scope.scope_prototype_xml;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
