package example.aspect.advice_around;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User findOne(String name) {
		if (name.equals("trap")) throw new RuntimeException();
		return new User(name);
	}

}
