package example.jdbc.queryforlist;

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
    		List<Room> rooms = dao.getAllRoom();
    		System.out.println("rooms: " + rooms);
    	}
    }
}
