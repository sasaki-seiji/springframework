package example.beanlifecycle.predestroy_disposablebean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService, DisposableBean {
	@Autowired
	UserRepository userRepository;

	@Override
	public void destroy() {
		clearCache();
	}
	
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
