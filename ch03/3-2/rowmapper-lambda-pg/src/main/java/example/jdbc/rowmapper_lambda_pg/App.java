package example.jdbc.rowmapper_lambda_pg;

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

    		Room room = dao.getRoomById("X9999");
    		System.out.println("room: " + room);
    		
    		List<Room> roomList = dao.getAllRoom();
    		System.out.println("roomList: " + roomList);
    	}
    }
}
