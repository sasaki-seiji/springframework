package example.aspect.advice_after_throwing;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		if (name.equals("spring")) throw new RuntimeException();
		return new User(name);
	}

}
