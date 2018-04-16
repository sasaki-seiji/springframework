package example.jdbc.update;

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

    		List<Room> rooms = dao.getAllRoom();
    		System.out.println("initially: " + rooms);
    		
    		Room room = new Room("B001", "共用会議室", 8);
    		int count = dao.insertRoom(room);
    		System.out.println("inderted: " + count);
    		rooms = dao.getAllRoom();
    		System.out.println("after insert: " + rooms);
    		
    		room.setRoomName("役員会議室");
    		room.setCapacity(6);
    		count = dao.updateRoomById(room);
    		System.out.println("updated: " + count);
    		rooms = dao.getAllRoom();
    		System.out.println("after update: " + rooms);
    		
    		count = dao.deleteRoomById(room.getRoomId());
    		System.out.println("deleted: " + count);
    		rooms = dao.getAllRoom();
    		System.out.println("after delete: " + rooms);
    	}
    }
}
