package example.jdbc.resultsetextractor_pg;

import java.util.List;

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

    		Room room = dao.getRoomWithEquipmentById("A001");
    		System.out.println("room: " + room);
    		
    		List<Room> roomList = dao.getAllRoomWithEquipment();
    		System.out.println("roomList: " + roomList);
    	}
    }
}
