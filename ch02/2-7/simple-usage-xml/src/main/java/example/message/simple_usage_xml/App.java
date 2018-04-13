package example.message.simple_usage_xml;

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
    		WelcomeMessage welcome = context.getBean(WelcomeMessage.class);
    		welcome.printWelcomeMessage();
    	}
    }
}
