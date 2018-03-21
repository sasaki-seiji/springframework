package example.beandef.annotation_config_xml;

public interface UserRepository {
	User save(User user);
	int countByUsername(String username);
}
