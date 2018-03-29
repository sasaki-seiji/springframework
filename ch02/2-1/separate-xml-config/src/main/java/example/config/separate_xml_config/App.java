package example.config.separate_xml_config;

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
			DataSource dataSource = context.getBean(DataSource.class);
			System.out.println("userSerivice: " + userService);
			System.out.println("dataSource: " + dataSource);
    	}
    }
}
