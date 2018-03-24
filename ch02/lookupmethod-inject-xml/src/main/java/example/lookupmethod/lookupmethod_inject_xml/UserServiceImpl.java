package example.lookupmethod.lookupmethod_inject_xml;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			throw new UserAlreadyRegisteredException();
		}
	
		PasswordEncoder passwordEncoder = passwordEncoder();
		user.setPassword(passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}
	
	PasswordEncoder passwordEncoder() {
		return null;
	}
}
