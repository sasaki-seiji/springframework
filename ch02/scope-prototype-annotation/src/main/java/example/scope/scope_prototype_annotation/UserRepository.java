package example.scope.scope_prototype_annotation;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
