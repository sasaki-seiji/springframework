package com.example.audit;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.RoomWithAudit;
import com.example.domain.repository.RoomWithAuditService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		RoomWithAuditService roomWithAuditService = context.getBean("roomWithAuditService", RoomWithAuditService.class);

       		List<RoomWithAudit> rooms = roomWithAuditService.getAllRoomsWithAudit();
       		System.err.println("initially all rooms: " + rooms);
       		
       		RoomWithAudit room = roomWithAuditService.createRoomWithAudit("new room#1", 10);
       		Integer id1 = room.getRoomId();
       		System.err.println("created room(" + id1 + "): " + room);
      		
       		room = roomWithAuditService.createRoomWithAudit("new room#2", 20);
       		Integer id2 = room.getRoomId();
       		System.err.println("created room(" + id2 + "): " + room);
      		
       		room = roomWithAuditService.updateRoomName(id1, "new room name#1");
       		System.err.println("update room name: " + room);

       		roomWithAuditService.deleteRoomWithAudit(id2);
       		System.err.println("room(" + id2 + "): deleted");

       		rooms = roomWithAuditService.getAllRoomsWithAudit();
       		System.err.println("finally all rooms: " + rooms);
    	}
    }
}
