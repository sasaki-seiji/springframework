package example.autowiring.autowired_qualifier_name;

import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User save(User user) {
		System.out.println("save: " + user.getUsername());
		return user;
	}

	@Override
	public int countByUsername(String username) {
		System.out.println("countByUsername: " + username);
		return 0;
	}

}
