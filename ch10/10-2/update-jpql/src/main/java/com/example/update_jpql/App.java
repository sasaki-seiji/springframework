package com.example.update_jpql;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Equipment;
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
       		System.err.println("initial rooms state: " + rooms);

       		int count = roomService.updateCapacityAll(50);
       		System.err.println("updateCapaityAll(50): " + count);

       		rooms = roomService.getAllRooms();
       		System.err.println("final rooms state: " + rooms);
    	}
    }
}
