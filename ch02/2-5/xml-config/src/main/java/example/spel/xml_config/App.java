package example.spel.xml_config;

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
    		TemporaryDirectory temporaryDirectory = context.getBean(TemporaryDirectory.class);
    		System.out.println("directory: " + temporaryDirectory.getDirectory());
    	}
    }
}
