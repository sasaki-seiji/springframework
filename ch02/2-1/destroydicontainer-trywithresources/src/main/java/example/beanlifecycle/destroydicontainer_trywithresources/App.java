package example.beanlifecycle.destroydicontainer_trywithresources;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfig.class)) {
			UserService userService = context.getBean(UserService.class);
			User user = new User("sasaki");
			userService.register(user, "seiji");
			System.out.println("username: " + user.getUsername());
			System.out.println("password: " + user.getPassword());
    	}
    }
}
