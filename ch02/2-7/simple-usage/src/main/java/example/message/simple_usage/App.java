package example.message.simple_usage;

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
    		WelcomeMessage welcome = context.getBean(WelcomeMessage.class);
    		welcome.printWelcomeMessage();
    	}
    }
}
