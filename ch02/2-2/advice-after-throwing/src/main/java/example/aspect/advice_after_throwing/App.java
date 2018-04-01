package example.aspect.advice_after_throwing;

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
	    	User user = userService.findOne("spring");
	    	System.out.println("user: " + user);
    	}
    }
}
