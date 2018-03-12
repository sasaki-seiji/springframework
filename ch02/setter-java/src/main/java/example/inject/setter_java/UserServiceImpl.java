package example.inject.setter_java;

public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl() {
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			throw new UserAlreadyRegisteredException();
		}
		
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}
}
