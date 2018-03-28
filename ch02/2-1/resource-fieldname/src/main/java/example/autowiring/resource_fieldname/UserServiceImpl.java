package example.autowiring.resource_fieldname;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	@Resource
	UserRepository userRepository;
	
	@Resource
	PasswordEncoder sha256PasswordEncoder;
	
	@Override
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			throw new UserAlreadyRegisteredException();
		}
		
		user.setPassword(this.sha256PasswordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}
}
