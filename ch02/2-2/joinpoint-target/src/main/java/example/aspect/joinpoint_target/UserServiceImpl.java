package example.aspect.joinpoint_target;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		return new User(name);
	}

}
