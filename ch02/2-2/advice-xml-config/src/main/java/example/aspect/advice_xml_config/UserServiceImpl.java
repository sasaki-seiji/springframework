package example.aspect.advice_xml_config;

public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		return new User(name);
	}

}
