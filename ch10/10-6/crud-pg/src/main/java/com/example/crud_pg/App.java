package com.example.crud_pg;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Room;
import com.example.domain.repository.RoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		RoomService roomService = context.getBean("roomService", RoomService.class);

       		List<Room> rooms = roomService.getAllRooms();
       		System.err.println("initially all rooms: " + rooms);
       		
       		Room room = roomService.getRoom(2);
       		System.err.println("room(2): " + room);
       		
       		room = roomService.createRoom("new room", 50);
       		Integer newId = room.getRoomId();
       		System.err.println("room(" + newId + "): " + room);
      		
       		room = roomService.updateRoomName(newId, "new room name");
       		System.err.println("room(" + newId + "): " + room);

       		roomService.deleteRoom(newId);
       		System.err.println("room(" + newId + "): deleted");

       		rooms = roomService.getAllRooms();
       		System.err.println("finally all rooms: " + rooms);
    	}
    }
}
