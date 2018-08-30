package example.jdbc.resultsetextractor_pg;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    		// 2018.08.30 add for exception test
    		try {
    			room = dao.getRoomWithEquipmentById("X001");
    			System.out.println("room: " + room);
    		}
    		catch (RuntimeException e) {
    			System.out.println("error: " + e);
    		}
    	}
    }
}
