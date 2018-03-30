package example.config.jsr330_java_config;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Inject
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
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
