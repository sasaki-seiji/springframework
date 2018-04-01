package example.aspect.advice_after_throwing_propagate;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		if (name.equals("spring")) throw new DataAccessException();
		return new User(name);
	}

}
