package com.example.optimistic_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.Room;
import com.example.repository.RoomService;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		RoomService roomService = context.getBean("roomService", RoomService.class);

       		Room room = roomService.getRoom(2);
       		System.err.println("initially room(2): " + room);

       		roomService.updateRoomWithOptimisticLock(2, "セミナールームA", 50);
       		System.err.println("update room(2)");

       		room = roomService.getRoom(2);
       		System.err.println("after update room(2): " + room);
       		
       		// competition
       		ExecutorService executor = Executors.newFixedThreadPool(2);
       		try {
       		  executor.execute(new RoomUpdater(roomService, 2, "room-A", 45, 10));
       		  executor.execute(new RoomUpdater(roomService, 2, "room-B", 55, 10));
       		} finally {
       		  executor.shutdown();
       		  executor.awaitTermination(10, TimeUnit.MINUTES);
       		}       		
    	}
    }
}
