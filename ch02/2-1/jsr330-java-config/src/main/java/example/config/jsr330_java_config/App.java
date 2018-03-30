package example.config.jsr330_java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfig.class)) {
	    	UserService userService1 = context.getBean(UserService.class);
	    	User user1 = new User("sasaki");
	    	userService1.register(user1, "seiji");
	    	System.out.println("username: " + user1.getUsername());
	    	System.out.println("password: " + user1.getPassword());

	    	UserService userService2 = context.getBean(UserService.class);
	    	User user2 = new User("sophia");
	    	userService2.register(user2, "2008");
	    	System.out.println("username: " + user2.getUsername());
	    	System.out.println("password: " + user2.getPassword());

	    	System.out.println(userService1);
	    	System.out.println(userService2);
    	}
    }
}
