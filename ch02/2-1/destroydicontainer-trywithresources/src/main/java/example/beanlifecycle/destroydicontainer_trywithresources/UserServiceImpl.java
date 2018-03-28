package example.beanlifecycle.destroydicontainer_trywithresources;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@PreDestroy
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
