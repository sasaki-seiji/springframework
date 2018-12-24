package com.example.pagination_pg;

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

       		List<Room> rooms = roomService.searchRoomByNameLikeAsc("room-1", 0, 5);
       		System.err.println("rooms(roomName LIKE room-1%, Page(0,5)): " + rooms);
       		
       		rooms = roomService.searchRoomByNameLikeAsc("room-1", 1, 5);
       		System.err.println("rooms(roomName LIKE room-1%, Page(1,5)): " + rooms);
       		
    	}
    }
}
