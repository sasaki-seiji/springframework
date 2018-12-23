package com.example.jpql_methodname;

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

       		List<Room> rooms = roomService.findByRoomNameAndCapacity("セミナールーム", 30);
       		System.err.println("rooms(roomName=セミナールーム, capacity=30): " + rooms);
       		
       		rooms = roomService.findDistinctRoomByEquipments_EquipmentName("プロジェクタ");
       		System.err.println("rooms(equipmentName=プロジェクタ): " + rooms);
       		
       		rooms = roomService.findByCapacityBetween(10,50);
       		System.err.println("rooms(capacity:[10,50]): " + rooms);
       		
    	}
    }
}
