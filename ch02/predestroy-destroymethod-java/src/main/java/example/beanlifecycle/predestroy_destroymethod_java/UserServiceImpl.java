package example.beanlifecycle.predestroy_destroymethod_java;


public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	void clearCache() {
		System.out.println("clearCache: " + this);
	}
	
	@Override
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			throw new UserAlreadyRegisteredException();
		}
		
		user.setPassword(rawPassword);
		this.userRepository.save(user);
	}
}
