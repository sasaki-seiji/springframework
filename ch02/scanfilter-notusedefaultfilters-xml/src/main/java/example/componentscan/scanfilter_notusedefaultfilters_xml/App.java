package example.componentscan.scanfilter_notusedefaultfilters_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context 
    			= new ClassPathXmlApplicationContext("applicationContext.xml")) {
	    	CollectionService collectionService = context.getBean(CollectionService.class);
	    	System.out.println(collectionService.domainServiceList);
	    	AnotherComponent anotherComponent = collectionService.anotherComponenct;
	    	if (anotherComponent != null)
	    		System.out.println(anotherComponent);
    	}
    }
}
