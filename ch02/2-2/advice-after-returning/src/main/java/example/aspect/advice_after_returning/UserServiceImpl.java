package example.aspect.advice_after_returning;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		return new User(name);
	}

}
