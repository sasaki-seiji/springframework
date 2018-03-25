package example.beanlifecycle.postconstruct_initializingbean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService, InitializingBean {
	@Autowired
	UserRepository userRepository;

	@Override
	public void afterPropertiesSet() {
		populateCache();
	}
	
	void populateCache() {
		System.out.println("populateCache: " + this);
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
