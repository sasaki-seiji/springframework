package com.example.Result_annotation;

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

        	MeetingRoom meetingRoom = meetingRoomService.findOne("002");
        	System.out.println("findOne(002): " + meetingRoom);
        	
        	long count = meetingRoomService.count();
        	System.out.println("count(): " + count);
        	
        	List<MeetingRoom> list = meetingRoomService.findAll();
        	System.out.println("findAll(): " + list);
    	}
    }
}
