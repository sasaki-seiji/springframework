package example.autowiring.autowired_optional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	Optional<PasswordEncoder> passwordEncoder;
	
	@Override
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			throw new UserAlreadyRegisteredException();
		}
		
		String encodedPassword = passwordEncoder.map(x -> x.encode(rawPassword))
					.orElse(rawPassword);
		user.setPassword(encodedPassword);
		this.userRepository.save(user);
	}
}
