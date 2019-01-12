package com.example.sql_builder;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;
import com.example.domain.repository.MeetingRoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(AppConfig.class)) {
        	MeetingRoomService meetingRoomService 
        		= context.getBean("meetingRoomService", MeetingRoomService.class);

        	MeetingRoomCriteria criteria1= new MeetingRoomCriteria();
        	criteria1.setRoomId("A-");
        	List<MeetingRoom> meetingRooms = meetingRoomService.findByCriteria(criteria1);
        	System.out.println("findByCriteria(roomId:\"A-%\"): " + meetingRooms);
        	
        	MeetingRoomCriteria criteria2= new MeetingRoomCriteria();
        	criteria2.setRoomName("CR-");
        	meetingRooms = meetingRoomService.findByCriteria(criteria2);
        	System.out.println("findByCriteria(roomName:\"CR-%\"): " + meetingRooms);
        	
        	MeetingRoomCriteria criteria3= new MeetingRoomCriteria();
        	criteria3.setCapacity(30);
        	meetingRooms = meetingRoomService.findByCriteria(criteria3);
        	System.out.println("findByCriteria(capacity:30): " + meetingRooms);
        	
        	MeetingRoomCriteria criteria4= new MeetingRoomCriteria();
        	criteria4.setRoomName("MR-");
        	criteria4.setCapacity(20);
        	meetingRooms = meetingRoomService.findByCriteria(criteria4);
        	System.out.println("findByCriteria(roomName:\"MR-%\", capacity:20): " + meetingRooms);
        	
    	}
    }
}
