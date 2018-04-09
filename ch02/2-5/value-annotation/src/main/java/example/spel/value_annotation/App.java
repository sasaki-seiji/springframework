package example.spel.value_annotation;

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
    		TemporaryDirectory temporaryDirectory = context.getBean(TemporaryDirectory.class);
    		System.out.println("directory: " + temporaryDirectory.getDirectory());
    	}
    }
}
