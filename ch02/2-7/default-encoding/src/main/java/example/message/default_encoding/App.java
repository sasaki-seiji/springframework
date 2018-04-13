package example.message.default_encoding;

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
    		ProcessMessage process = context.getBean(ProcessMessage.class);
    		process.printDoneMessage();
    	}
    }
}
