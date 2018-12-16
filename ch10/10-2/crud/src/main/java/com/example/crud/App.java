package com.example.crud;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Room;
import com.example.repository.RoomService;

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
       		System.err.println("room(new): " + room);
      		
       		room = roomService.updateRoomName(4, "new room name");
       		System.err.println("room(4): " + room);

       		roomService.deleteRoom(4);
       		System.err.println("room(4): deleted");

       		rooms = roomService.getAllRooms();
       		System.err.println("finally all rooms: " + rooms);
    	}
    }
}
