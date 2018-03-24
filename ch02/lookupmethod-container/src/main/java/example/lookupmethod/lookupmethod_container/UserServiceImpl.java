package example.lookupmethod.lookupmethod_container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	ApplicationContext context;
	
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
		return this.context.getBean(PasswordEncoder.class);
	}
}
