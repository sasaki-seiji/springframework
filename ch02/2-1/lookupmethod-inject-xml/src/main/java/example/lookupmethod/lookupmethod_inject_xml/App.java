package example.lookupmethod.lookupmethod_inject_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context 
    			= new ClassPathXmlApplicationContext("applicationContext.xml")) {
	    	UserService userService = context.getBean(UserService.class);
	    	User user1 = new User("sasaki");
	    	userService.register(user1, "seiji");
	    	System.out.println("username: " + user1.getUsername());
	    	System.out.println("password: " + user1.getPassword());

	    	User user2 = new User("sophia");
	    	userService.register(user2, "2008");
	    	System.out.println("username: " + user2.getUsername());
	    	System.out.println("password: " + user2.getPassword());
    	}
    }
}
