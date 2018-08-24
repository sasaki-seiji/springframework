package example.datasource.postgres;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	try(ConfigurableApplicationContext context 
    			= new AnnotationConfigApplicationContext(PoolingDataSourceConfig.class)) {
    		DataSource dataSource = context.getBean(DataSource.class);
    		System.out.println("dataSource: " + dataSource);
    		Connection conn = dataSource.getConnection();
    		System.out.println("connection: " + conn);
    	}
    }
}
