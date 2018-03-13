package example.beandef.xml_config;

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
	    	User user = new User("sasaki");
	    	userService.register(user, "seiji");
    	}
    }
}
