package example.aspect.simple_aop_xml;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		return new User(name);
	}

}
