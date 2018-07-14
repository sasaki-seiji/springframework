package example.handle_errorresponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfig.class)) {
    		RestApiCaller caller = context.getBean(RestApiCaller.class); 
	    	caller.call();
    	}
    }
}
