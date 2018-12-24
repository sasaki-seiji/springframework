package com.example.custom_repository;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Room;
import com.example.domain.repository.RoomCriteria;
import com.example.domain.repository.RoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		RoomService roomService = context.getBean("roomService", RoomService.class);

       		RoomCriteria criteria = new RoomCriteria();
       		criteria.setCapacityMin(10);
       		List<Room> rooms = roomService.findByCriteria(criteria);
       		System.err.println("rooms(capacity >= 10) :" + rooms);

       		criteria = new RoomCriteria();
       		criteria.setCapacityMax(6);
       		rooms = roomService.findByCriteria(criteria);
       		System.err.println("rooms(capacity <= 6) :" + rooms);

       		criteria = new RoomCriteria();
       		criteria.setRoomNameLike("room-2%");
       		rooms = roomService.findByCriteria(criteria);
       		System.err.println("rooms(roomName LIKE room-2%) :" + rooms);

       		criteria = new RoomCriteria();
       		criteria.setRoomNameLike("room-2%");
       		criteria.setCapacityMin(8);
       		rooms = roomService.findByCriteria(criteria);
       		System.err.println("rooms(roomName LIKE room-2% AND cpacity >= 8) :" + rooms);
    	}
    }
}
