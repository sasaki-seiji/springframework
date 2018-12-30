package com.example.jpql;

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

       		List<Room> rooms = roomService.getRoomsByName("セミナールーム");
       		System.err.println("rooms(roomName='セミナールーム'): " + rooms);
      		
       	}
    }
}
