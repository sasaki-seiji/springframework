package com.example.basic_jdbc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.TransactionManagerConfig;
import com.example.domain.model.Room;
import com.example.repository.RoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(TransactionManagerConfig.class)) {
        		RoomService roomService = context.getBean("roomService", RoomService.class);

        		Room room = roomService.getRoom("C001001");
        		System.out.println("room(C001001): " + room);

        	}
    }
}
