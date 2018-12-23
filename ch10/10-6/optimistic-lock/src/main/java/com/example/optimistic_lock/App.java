package com.example.optimistic_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.JpaConfig;
import com.example.domain.model.RoomWithVersion;
import com.example.domain.repository.RoomWithVersionService;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(JpaConfig.class)) {
       		RoomWithVersionService roomWithVersionService = context.getBean("roomService", RoomWithVersionService.class);

       		RoomWithVersion room = roomWithVersionService.getRoom(2);
       		System.err.println("initially room(2): " + room);

       		roomWithVersionService.updateRoomWithOptimisticLock(2, "セミナールームA", 50);
       		System.err.println("update room(2)");

       		room = roomWithVersionService.getRoom(2);
       		System.err.println("after update room(2): " + room);
       		
       		// competition
       		ExecutorService executor = Executors.newFixedThreadPool(2);
       		RoomUpdater updater1 = new RoomUpdater(roomWithVersionService, 2, "room-A", 45, 100);
       		RoomUpdater updater2 = new RoomUpdater(roomWithVersionService, 2, "room-B", 55, 100);
       		executor.execute(updater1);
       		executor.execute(updater2);
       		executor.shutdown();
       		executor.awaitTermination(10, TimeUnit.MINUTES);
    		System.err.println("room-A - success: " + updater1.getSuccess() + ", failure: " + updater1.getFailure());
    		System.err.println("room-B - success: " + updater2.getSuccess() + ", failure: " + updater2.getFailure());

       		room = roomWithVersionService.getRoom(2);
       		System.err.println("after ucompetition room(2): " + room);
    	
    	}
    }
}
