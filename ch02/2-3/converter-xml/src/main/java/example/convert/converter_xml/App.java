package example.convert.converter_xml;

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
    		ApplicationProperties properties = context.getBean(ApplicationProperties.class);
    		System.out.println("adminEmail: " + properties.getAdminEmail());
    	}
    }
}
