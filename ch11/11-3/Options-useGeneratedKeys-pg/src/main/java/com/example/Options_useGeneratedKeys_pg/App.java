package com.example.Options_useGeneratedKeys_pg;

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

        	MeetingRoom newMeetingRoom = new MeetingRoom();
        	newMeetingRoom.setRoomName("会議室B");
        	newMeetingRoom.setCapacity(8);
        	
        	meetingRoomService.create(newMeetingRoom);
        	System.out.println("created: " + newMeetingRoom);
        	
        	List<MeetingRoom> list = meetingRoomService.findAll();
        	System.out.println("findAll(): " + list);
    	}
    }
}
