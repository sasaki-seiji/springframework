package example.transaction.platformtransactionmanager;

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

        		Room room = roomService.getRoom("C001001");
        		System.out.println("room(C001001): " + room);

        		Room newRoom = new Room("B001", "新しい部屋", 5);
        		Equipment equipment = new Equipment();
        		equipment.setEquipmentId("50-1");
        		equipment.setRoomId("B001"); 
        		equipment.setEquipmentName("ホワイトボード");
        		equipment.setEquipmentCount(1);
        		equipment.setEquipmentRemarks("小型");
        		newRoom.getEquipmentList().add(equipment);
        		roomService.insertRoom(newRoom);
        		room = roomService.getRoom("B001");
        		System.out.println("room(B001): " + room);
        	}
    }
}
