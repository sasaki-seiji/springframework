package example.autowiring.autowired_collection_bean;


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
	    	System.out.println(collectionService.ifList_autowired);
	    	System.out.println(collectionService.ifMap_autowired);
	    	System.out.println(collectionService.ifList_resource);
	    	System.out.println(collectionService.ifMap_resource);
    	}
    }
}
