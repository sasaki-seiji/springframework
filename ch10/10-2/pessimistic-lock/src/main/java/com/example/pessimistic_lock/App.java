package com.example.pessimistic_lock;

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

       		Room room = roomService.getRoom(2);
       		System.err.println("initially room(2): " + room);

       		roomService.updateRoomWithPessimisticLock(2, "セミナールームA", 50);
       		System.err.println("update room(2)");

       		room = roomService.getRoom(2);
       		System.err.println("after update room(2): " + room);
       		
    	}
    }
}
