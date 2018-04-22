package example.dataaccessexception.handle_exception;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(TransactionManagerConfig.class)) {
       		RoomService roomService = context.getBean("roomService", RoomService.class);

       		// update room "A001"
       		Room room = roomService.getRoom("A001");
       		System.out.println("initial A001: " + room);
       		
       		room = roomService.getRoomForUpdate("A001");
       		room.setCapacity(20);
       		roomService.updateRoom(room);
       		room = roomService.getRoom("A001");
       		System.out.println("updated A001: " + room);
       		
       		// update room "B001"
       		try {
	       		room = roomService.getRoomForUpdate("B001");
	       		room.setCapacity(20);
	       		roomService.updateRoom(room);
	       		room = roomService.getRoom("B001");
	       		System.out.println("updated B001: " + room);
       		} catch(Exception e) {
       			System.out.println("... update B001 fails ...");
       			System.out.println(e);
       		}
       		
       	}
    }
}
