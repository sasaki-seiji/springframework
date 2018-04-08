package example.convert.converter;

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
    		ApplicationProperties properties = context.getBean(ApplicationProperties.class);
    		System.out.println("adminEmail: " + properties.getAdminEmail());
    	}
    }
}
