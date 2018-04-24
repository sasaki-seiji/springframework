package example.jdbc.bindparam_pg;

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
    		String roomName = dao.findRoomNameById("X9999");
    		System.out.println("roomName: " + roomName);
    	}
    }
}
