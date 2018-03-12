package example.inject.setter_xml;

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
