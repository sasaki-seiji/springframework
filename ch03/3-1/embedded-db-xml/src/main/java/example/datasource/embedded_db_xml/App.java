package example.datasource.embedded_db_xml;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
    			= new ClassPathXmlApplicationContext("datasourceEmbeddedConfig.xml")) {
    		DataSource dataSource = context.getBean(DataSource.class);
    		System.out.println("dataSource: " + dataSource);
    	}
    }
}
