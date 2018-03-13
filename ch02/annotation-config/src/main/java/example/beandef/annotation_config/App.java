package example.beandef.annotation_config;

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
	    	UserService userService = context.getBean(UserService.class);
	    	User user = new User("sasaki");
	    	userService.register(user, "seiji");
    	}
    }
}
