package com.example.one_to_many_mapping_pg;

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

        	MeetingRoom meetingRoom = meetingRoomService.findOne("A-001");
        	System.out.println("findOne(A-001): " + meetingRoom);
        	
        	meetingRoom = meetingRoomService.findOne("A-003");
        	System.out.println("findOne(A-003): " + meetingRoom);
    	}
    }
}
