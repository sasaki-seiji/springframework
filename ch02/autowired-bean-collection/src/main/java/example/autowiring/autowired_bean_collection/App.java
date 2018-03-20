package example.autowiring.autowired_bean_collection;

import java.util.Map;

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
	    	for (IF elem : collectionService.ifList) {
	    		System.out.println(elem);
	    	}
	    	for (Map.Entry<String, IF> elem 
	    			: collectionService.ifMap.entrySet()) {
	    		System.out.println(elem);
	    	}
	    	for (IF<Integer> elem : collectionService.intIFList) {
	    		System.out.println(elem);
	    	}
	    	for (Map.Entry<String, IF<Integer>> elem 
	    			: collectionService.intIFMap.entrySet()) {
	    		System.out.println(elem);
	    	}
    	}
    }
}
