package example.autowiring.resource_propertyname;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	@Resource
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder;
	
	@Resource
	public void setSha256PasswordEncoder(PasswordEncoder passwordEncoder) {
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
