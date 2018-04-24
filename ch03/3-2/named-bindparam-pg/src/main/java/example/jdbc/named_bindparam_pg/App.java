package example.jdbc.named_bindparam_pg;

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
    		JdbcRoomNamedDao dao = context.getBean("jdbcRoomNamedDao", JdbcRoomNamedDao.class);
    		String roomName = dao.findRoomNameById("X9999");
    		System.out.println("roomName: " + roomName);
    	}
    }
}
