package example.transaction.platformtransactionmanager_pg;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

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
    		equipment.setEquipmentId("30-2");
    		equipment.setRoomId("B001"); 
    		equipment.setEquipmentName("ホワイトボード");
    		equipment.setEquipmentCount(1);
    		equipment.setEquipmentRemarks("小型");
    		newRoom.getEquipmentList().add(equipment);
    		roomService.insertRoom(newRoom);
    		room = roomService.getRoom("B001");
    		System.out.println("room(B001): " + room);
  
       		newRoom = new Room("B002", "もう一つの新しい部屋", 5);
    		equipment = new Equipment();
    		equipment.setEquipmentId("30-2"); // duplicate ID
    		equipment.setRoomId("B002"); 
    		equipment.setEquipmentName("ホワイトボード");
    		equipment.setEquipmentCount(1);
    		equipment.setEquipmentRemarks("小型");
    		newRoom.getEquipmentList().add(equipment);
    		try {
    			roomService.insertRoom(newRoom);
    			System.out.println("... insertRoom(B002) succeeds ...");
    		} catch(DataAccessException e) {
    			System.out.println("... insertRoom(B002) fails ...");
    				// JdbcRoomDao.insertRoom("B002") have to be rollbacked
    			System.out.println(e);
    		}
    		try {
    			room = roomService.getRoom("B002");
    			System.out.println("... getRoom(B002) succeeds ... : " + room);
    		} catch(DataAccessException e) {
    			System.out.println("... getRoom(B002) fails ...");
    			System.out.println(e);
    		}

    	}
    }
}
