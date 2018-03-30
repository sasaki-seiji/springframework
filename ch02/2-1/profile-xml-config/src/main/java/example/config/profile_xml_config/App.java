package example.config.profile_xml_config;

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
			DataSource dataSource = context.getBean(DataSource.class);
			System.out.println("dataSource: " + dataSource);
    	}
    }
}
