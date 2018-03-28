package example.lookupmethod.lookupmethod_inject_annotation;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
