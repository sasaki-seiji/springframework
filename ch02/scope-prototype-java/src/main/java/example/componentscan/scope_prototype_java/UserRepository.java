package example.componentscan.scope_prototype_java;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
