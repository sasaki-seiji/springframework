package example.datasource.postgres;

import javax.sql.DataSource;

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
    			= new AnnotationConfigApplicationContext(PoolingDataSourceConfig.class)) {
    		DataSource dataSource = context.getBean(DataSource.class);
    		System.out.println("dataSource: " + dataSource);
    	}
    }
}
