package com.example.relation;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Equipment;
import com.example.domain.model.Room;
import com.example.domain.repository.RoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		RoomService roomService = context.getBean("roomService", RoomService.class);

       		Room room = roomService.getRoomById(2);
       		System.err.println("room(2): " + room);
       		
       		List<Equipment> equipments = roomService.getEquipmentsInRoom(2);
       		System.err.println("equipments in room(2): " + equipments);
       		
       		room = roomService.getRoomOfEquipment(2);
       		System.err.println("room of equipment(2): " + room);
       	}
    }
}
