package com.example.resulthandler_pg;

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

        	meetingRoomService.collectAll(cntxt -> {
        		int resultPosition = cntxt.getResultCount();
        		MeetingRoom meetingRoom = cntxt.getResultObject();
            	System.out.println(resultPosition + ": " + meetingRoom);
        	});
    	}
    }
}
