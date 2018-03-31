package example.aspect.simple_aop_xml;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
    			= new ClassPathXmlApplicationContext("applicationContext.xml")) {
	    	UserService userService = context.getBean(UserService.class);
	    	User user = userService.findOne("spring");
	    	System.out.println("user: " + user);
    	}
    }
}
