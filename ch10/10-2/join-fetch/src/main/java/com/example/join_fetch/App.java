package com.example.join_fetch;

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

       		List<Room> rooms = roomService.getRoomsByNameFetch("セミナールーム");
       		System.err.println("room(roomName=セミナールーム): " + rooms);

       		List<Equipment> equipments = rooms.get(0).getEquipments();
       		System.err.println("room(roomName=セミナールーム).equipments: " + equipments);
    	}
    }
}
