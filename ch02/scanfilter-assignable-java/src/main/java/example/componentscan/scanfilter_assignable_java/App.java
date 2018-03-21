package example.componentscan.scanfilter_assignable_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfig.class)) {
	    	CollectionService collectionService = context.getBean(CollectionService.class);
	    	System.out.println(collectionService.domainServiceList);
	    	AnotherComponent anotherComponent = collectionService.anotherComponenct;
	    	if (anotherComponent != null)
	    		System.out.println(anotherComponent);
    	}
    }
}
