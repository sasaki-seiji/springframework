package example.autowiring.autowired_required_false;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired(required = false)
	PasswordEncoder passwordEncoder;
	
	@Override
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			throw new UserAlreadyRegisteredException();
		}
		
		String encodedPassword = ( passwordEncoder != null ) ?
					passwordEncoder.encode(rawPassword) : rawPassword;
		user.setPassword(encodedPassword);
		this.userRepository.save(user);
	}
}
