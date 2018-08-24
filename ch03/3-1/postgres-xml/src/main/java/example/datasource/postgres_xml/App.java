package example.datasource.postgres_xml;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	try(ConfigurableApplicationContext context 
    			= new ClassPathXmlApplicationContext("datasourcePostgresConfig.xml")) {
    		DataSource dataSource = context.getBean(DataSource.class);
    		System.out.println("dataSource: " + dataSource);
    		Connection conn = dataSource.getConnection();
    		System.out.println("connection: " + conn);
    	}
    }
}
