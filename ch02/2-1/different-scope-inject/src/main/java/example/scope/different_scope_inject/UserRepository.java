package example.scope.different_scope_inject;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
