package example.resource.resource_inject;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	try(ConfigurableApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfig.class)) {
        	ResourceAccessor accessor = context.getBean(ResourceAccessor.class);
        	accessor.accessResource();
    	}
    }
}
