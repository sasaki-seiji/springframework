package example.handle_timeout_xmlconf;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context 
    			= new ClassPathXmlApplicationContext("applicationContext.xml")) {
    		RestApiCaller caller = context.getBean(RestApiCaller.class); 
	    	caller.call();
    	}
    }
}
