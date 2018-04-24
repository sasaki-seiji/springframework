package example.jdbc.queryforobject_pg;

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
    			= new ClassPathXmlApplicationContext("JdbcTemplateConfig.xml")) {
    		JdbcRoomDao dao = context.getBean("jdbcRoomDao", JdbcRoomDao.class);
    		int maxCapacity = dao.findMaxCapacity();
    		System.out.println("maxCapacity: " + maxCapacity);
    	}
    }
}
