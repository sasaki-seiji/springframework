package com.example.where_choose;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.domain.model.MeetingRoom;
import com.example.domain.repository.MeetingRoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(AppConfig.class)) {
        	MeetingRoomService meetingRoomService 
        		= context.getBean("meetingRoomService", MeetingRoomService.class);

        	List<MeetingRoom> meetingRooms = meetingRoomService.findByCapacityClass("small");
        	System.out.println("findByCapacityClass(small): " + meetingRooms);
        	
        	meetingRooms = meetingRoomService.findByCapacityClass("middle");
        	System.out.println("findByCapacityClass(middle): " + meetingRooms);

        	meetingRooms = meetingRoomService.findByCapacityClass("large");
        	System.out.println("findByCapacityClass(large): " + meetingRooms);
        	
    	}
    }
}
