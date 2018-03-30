package example.config.profile_java_config;

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
			DataSource dataSource = context.getBean(DataSource.class);
			System.out.println("dataSource: " + dataSource);
    	}
    }
}
